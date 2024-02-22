package com.example.TuneHubProject.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.TuneHubProject.entities.User;
import com.example.TuneHubProject.services.UserServices;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
		@Autowired
		UserServices US;
	
		@PostMapping("/createOrder")
		@ResponseBody
		public String createOrder() {
			Order order=null;
			try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_1BqOcL32JZrzuQ", "YR3wzDx1DSS2QurOZlzuA3s0"
					+ "");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",50000);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);

			order = razorpay.orders.create(orderRequest);
		}
		catch(Exception e) {
			System.out.println("Exception while creating Payment ");
		}
		return order.toString();
}
		
		@PostMapping("/verify")
		@ResponseBody
		public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String signature) {
			try{
				RazorpayClient razorpay = new RazorpayClient("rzp_test_1BqOcL32JZrzuQ", "YR3wzDx1DSS2QurOZlzuA3s0");
				
				String verificationData = orderId + "|" + paymentId;

				boolean isValidSignature = Utils.verifySignature(verificationData, signature, "YR3wzDx1DSS2QurOZlzuA3s0");

		        return isValidSignature;
		    	} 
			catch (RazorpayException e) 
			{
		        e.printStackTrace();
		        return false;
		    }
		}
		
		@GetMapping("payment-success")
		public String paymentSuccess(HttpSession session){
			
			String email = (String) session.getAttribute("email");
			System.out.println(email);
			User u = US.getUser(email);
			System.out.println(u);
			u.setPremium(true);
			US.updateUser(u);
			return "login";
		}
		
		@GetMapping("/payment-failure")
		public String paymentFailure() {
			return "login";
		}
}
