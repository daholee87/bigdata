package exampleKafka;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class SourceData {

	public static void main(String[] args) throws Exception{		
		try {				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	} 

	public String getLogID(){//로그id 반환		 
		StringBuffer sb = new StringBuffer();
		
		sb.append(getUpperCase(4));
		sb.append(getNumber(6));	
	      
	    return sb.toString();
	}
	
	public String getCustID(){//고객id 반환		 
		StringBuffer sb = new StringBuffer();
		
		sb.append(getUpperCase(2));
		sb.append(getNumber(3));
		sb.append(getUpperCase(2));
			 	      
	    return sb.toString();
	}
	
	public String getLogDtm(){//로그일시 반환		
		StringBuffer sb = new StringBuffer();
		
		SimpleDateFormat sdf_dtm = new SimpleDateFormat("yyyymmddhhmmss");
		sdf_dtm.setTimeZone(TimeZone.getTimeZone("GMT+09:00"));
		Calendar cal = Calendar.getInstance();
		
		sb.append(sdf_dtm.format(cal.getTime()));
		
		return sb.toString();
	}
	
	public String getMID(){//기기id 반환		 
		StringBuffer sb = new StringBuffer();
		
		sb.append(getNumber(1));
		sb.append(getLowerCase(1));
		sb.append(getNumber(1));
		sb.append(getLowerCase(3));
		sb.append(getNumber(2));
		sb.append(getLowerCase(1));
		sb.append(getNumber(2));
		sb.append(getLowerCase(3));
			 	      
	    return sb.toString();
	}	
	
	public String getIpAddr(){//ip주소 반환
		StringBuffer sb = new StringBuffer();
		sb.append(getDotNum("ip"));
 	      
	    return sb.toString();
	}
	
	public String getOsType(){//OS유형		 
		return getRandOS();
	}
	
	public String getOsVer(){//OS유형
		StringBuffer sb = new StringBuffer();		
		sb.append(getDotNum("os"));
				  
	    return sb.toString();
	}
	
	public String getDealDm(){//거래일자 반환		
		StringBuffer sb = new StringBuffer();
		 
		SimpleDateFormat sdf_dm = new SimpleDateFormat("yyyyMMdd"); 
		sdf_dm.setTimeZone(TimeZone.getTimeZone("GMT+09:00"));
		Calendar cal = Calendar.getInstance();		
		sb.append(sdf_dm.format(cal.getTime()));
						
		return sb.toString();
	}
	
	public String getDealTxt(){//거래내용 반환		 
		StringBuffer sb = new StringBuffer();
		
		sb.append(getNumber(1));
		sb.append(getLowerCase(4));
		sb.append(getHan(5));
			 	      
	    return sb.toString();
	}	
	
	public String getRandOS(){//기기OS반환		
		StringBuffer sb = new StringBuffer();
					 
	    String RandomOS[] = { "ANDROID","iOS","ETC" };
	 	Random rnd = new Random();	 		 	
	    int randNum = rnd.nextInt(RandomOS.length);
	    
	    sb.append(RandomOS[randNum]);
	 	      
	    return sb.toString();
	}
	
	public String getRandRtCode(){//처리결과 반환
		StringBuffer sb = new StringBuffer();
		 
	    String RandomOS[] = {"OK","NOTOK","ERROR" };
	 	Random rnd = new Random();
	 	
	    int randNum = rnd.nextInt(RandomOS.length);  
	    
	    sb.append(RandomOS[randNum]);
	 	      
	    return sb.toString();
	 	      
	}
		
	public String getLowerCase(int length){//소문자 반환
		 
		StringBuffer sb = new StringBuffer();
		
		try {
			for(int i=0;i<length;i++){	        
				Random rnd = new Random();
				sb.append(String.valueOf((char)((int)(rnd.nextInt(26)) + 97)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return sb.toString();
	}
	
	public String getUpperCase(int length){//대문자 반환
		 
		StringBuffer sb = new StringBuffer();
		
		try {
			for(int i=0;i<length;i++){	        
				Random rnd = new Random();
				sb.append(String.valueOf((char) ((int) (rnd.nextInt(26)) + 65)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return sb.toString();
	}
	
	public String getNumber(int length){//숫자 반환
		 		
		StringBuffer sb = new StringBuffer();

		try {
			for(int i=0;i<length;i++){	        
				Random rnd = new Random();
				sb.append(rnd.nextInt(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return sb.toString();
	}
	
	public String getHan(int length){//한글 반환
 		
		StringBuffer sb = new StringBuffer();

		try {
			for(int i=0;i<length;i++){	        
				sb.append((char)((Math.random() * 11172) + 0xAC00));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return sb.toString();
	}
		
	public String getDotNum(String type){// IP주소,OS버전 반환
 		
		StringBuffer sb = new StringBuffer();
		
		try {
			
			if(type.contains("ip")) {
					
					for(int i=0;i<4;i++) {
						
						double rndval = Math.random();
						
						sb.append((int)(rndval * 255)+1);
						if(i > 2) break;
						sb.append(".");	
												
					}
					
				}else if(type.contains("os")){
					for(int i=0;i<3;i++) {
						
						double rndval = Math.random();
						
						sb.append((int)(rndval * 10)+1);
						if(i > 1) break;
						sb.append(".");							
					}
				
				}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return sb.toString();
	}
	
}
