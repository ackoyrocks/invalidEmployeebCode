package com.lowes.bfcode.batch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.batch.item.ItemProcessor;

import com.lowes.bfcode.batch.model.EmpBenefitCode;

public class EmpBenefitCodeItemProcessor implements ItemProcessor<EmpBenefitCode, EmpBenefitCode>{

	int count=0;
	@Override
	public EmpBenefitCode process(EmpBenefitCode result) throws Exception {
		
		count++;
		System.out.println("Records : " + count);
		System.out.println("Processing result :"+result);
		String encodedBenefitCode = URLEncoder.encode(result.getEmpNumber(), "UTF-8");
		String url = "http://10.11.172.1/cgi-bin/apps/empAuth.cgi?EMP_CODE=" + encodedBenefitCode;
		String urlResponse= callURL(url);
		System.out.println("For empBenefitCode " + result.getEmpNumber()+ " : " + urlResponse);
		System.out.println();
		System.out.println();
		
		
		if("Y".equals(urlResponse))
		{
			return null;
		}
		
	
		return result;
	}
	public static String callURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			 Properties systemSettings = System.getProperties();
		      systemSettings.put("proxySet", "true");
		      systemSettings.put("http.proxyHost", "proxy.ec.lowes.com");
		      systemSettings.put("http.proxyPort", "3128");
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
	
}
