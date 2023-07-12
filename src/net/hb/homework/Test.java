package net.hb.homework;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthScrollBarUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Test {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		System.out.println("1번 회원가입 2. 로그인 9.종료");
		String sel = sc.nextLine();
	
		switch (Integer.parseInt(sel)) {
		case 1 -> {
			Signup();
		}
		case 2 -> {
			Login();
			ListAfterLogin();
		}
	
		}
		if (Integer.parseInt(sel) == 9) {
			break;
		}
	
	}


	}//main

	public static void Signup() {
		Scanner sc = new Scanner(System.in);

		System.out.println("아이디 입력");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력");
		String pwd = sc.nextLine();
		System.out.println("이름 입력");
		String name = sc.nextLine();

		User user = new User(id, pwd, name);
		ArrayList<User> users = new ArrayList<User>();
		users=LoadUserData();
		users.add(user);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(users);

		try {
			FileWriter fw = new FileWriter("C:\\Mtest\\workJava\\my\\4weekHomework\\src\\net\\hb\\homework\\json\\userdata.json");
			fw.write(json);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}// signup
	
	public static ArrayList<User> LoadUserData() {
		ArrayList<User> users = new ArrayList<>();
		
		try {
			
		File file = new File("C:\\Mtest\\workJava\\my\\4weekHomework\\src\\net\\hb\\homework\\json", "userdata.json");
		if(!file.exists()) {
			return users;
		}

		FileReader fr = new FileReader("C:\\Mtest\\workJava\\my\\4weekHomework\\src\\net\\hb\\homework\\json\\userdata.json");
		Gson gson = new Gson();
		users = gson.fromJson(fr,new TypeToken<ArrayList<User>>(){}.getType());
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		
		return users;
	}
	
	public static User Login() {
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<User>();
		users = LoadUserData();
		
		System.out.println("아이디 입력");
		String inputid =  sc.nextLine();
		System.out.println("비밀번호 입력");
		String inputpwd =sc.nextLine();
		
		
		for(User user : users) {
			if(inputid.equals(user.getId()) && inputpwd.equals(user.getPwd())) {
				System.out.println("로그인에 성공");
				return user;
			}else {
				System.out.println("로그인에 실패");
				return Login();
			}
			
		}
		
		return null;	
	}
	
	public static void ListAfterLogin() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 예약 2. Q&A 9.처음으로 돌아가기");
			String sel = sc.nextLine();
			
			switch(Integer.parseInt(sel)){
			case 1 ->{
				System.out.println("X");
			}
				
			}
			if(Integer.parseInt(sel) == 9) {
				break;
			}
		}
		
		
	}

}// class
