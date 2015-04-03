package com.gmail.at.ivanehreshi.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.gmail.at.ivanehreshi.PhoneNumber;

@RunWith(Parameterized.class)
public class Test {
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{"", false},
				{"111 11 54", true},
				{"8 (913) 648 82 64", true},
				{"+1 1234 12-34-56", true}
				});
	}
	
	public String phone;
	
	public boolean result;
	
	public Test(String phone, boolean result){
		this.phone = phone;
		this.result = result;
	}
	
	@org.junit.Test
	public void test() {
		assertTrue("Phone check failed", PhoneNumber.checkValidity(phone) == result);
	}

}
