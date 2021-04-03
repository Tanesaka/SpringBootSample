package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.HelloService;
import com.example.demo.model.Employee;

//コントローラーの宣言(画面などからHTTPリクエストを受けるクラス)
@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;

//	Getメゾッドのhelloのリンクでhello.htmlへ遷移
//	(src/main/resources/templatesからの相対パスを下記戻り値に指定)
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
//	PostメゾッドのHTTPリクエストでhelloのリンク
	@PostMapping("/hello")
//	@RequestParamの引数はHTMLのname属性と一致させる※text1
//	Modelクラスを使って、別の画面に値を渡す。
//	（ModelクラスのaddAttributeメゾッドにキー名（"sample"）※表示先htmlで記述 と値(str)を指定
	public String postRequest(@RequestParam("text1")String str, Model model) {
		model.addAttribute("sample", str);
		
		return "hello/response";
	}
	
	
//	PostメゾッドのHTTPリクエストでhello/dbのリンク
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String id, Model model) {
		
//		1件検索（serviceのメゾッドを呼び出す）
		Employee employee = service.getEmployee(id);
		
//		検索結果をModelに登録（キー名は"employee"）
		model.addAttribute("employee", employee);
		
		return "hello/db";
	}
	
	

}
