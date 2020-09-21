package exampleKafka;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import AvroSchema.deal_log;
import AvroSchema.mobile_log;


public class ProducerAvro {
	
	public void send() throws Exception{
		
		System.out.println("ProducerAvro : mobile_log.");
		
		String mTopicName = "mlog";
		String dTopicName = "dlog";
						
		Properties configs = new Properties();
        configs.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094"); // kafka host 및 server 설정
        configs.put("acks", "1");                         	
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");      // serialize 설정
        configs.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer"); // serialize 설정
        
        //producer 생성
        KafkaProducer<String, byte[]> mproducer = new KafkaProducer<String, byte[]>(configs);
        KafkaProducer<String, byte[]> dproducer = new KafkaProducer<String, byte[]>(configs);
                      
        try {
        	
    		while(true){
    			
    			EncoderFactory mAvroEncoderFactory = EncoderFactory.get();
            	EncoderFactory dAvroEncoderFactory = EncoderFactory.get();
                SpecificDatumWriter<mobile_log> mAvroEventWriter = new SpecificDatumWriter<mobile_log>(mobile_log.SCHEMA$);
                SpecificDatumWriter<deal_log> dAvroEventWriter = new SpecificDatumWriter<deal_log>(deal_log.SCHEMA$);
                    
                ByteArrayOutputStream mstream = new ByteArrayOutputStream();
                ByteArrayOutputStream dstream = new ByteArrayOutputStream();
   			
    			BinaryEncoder mBinaryEncoder = mAvroEncoderFactory.binaryEncoder(mstream, null);
                BinaryEncoder dBinaryEncoder = dAvroEncoderFactory.binaryEncoder(dstream, null);
    			
        		mAvroEventWriter.write(mData(), mBinaryEncoder);
        		dAvroEventWriter.write(dData(), dBinaryEncoder);
            	mBinaryEncoder.flush();
            	dBinaryEncoder.flush(); 
            	ProducerRecord<String, byte[]> mdata = new ProducerRecord<String, byte[]>(mTopicName, mstream.toByteArray());
            	ProducerRecord<String, byte[]> ddata = new ProducerRecord<String, byte[]>(dTopicName, dstream.toByteArray());
            	
                mproducer.send(mdata);
                dproducer.send(ddata); 	 

    		}
        	        	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	        mproducer.flush();
	        dproducer.flush();
	        mproducer.close();
	        dproducer.close();	
		}
	
		System.out.println("Producer mobile_log Completed.");

	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("ProducerAvro Start.");		
		ProducerAvro produceAvro = new ProducerAvro();
		
		produceAvro.send();
				
    }   
	
	private static mobile_log mData() throws Exception{
		
		System.out.println("ProducerAvro mobile_log.");
	
		mobile_log mlog = new mobile_log();
		SourceData sData = new SourceData();
	
		mlog.setLogId(sData.getLogID());
		mlog.setCustId(sData.getCustID());
		mlog.setLogDtm(sData.getLogDtm());
		mlog.setMId(sData.getMID());
		mlog.setIpAddr(sData.getIpAddr());
		mlog.setOsType(sData.getRandOS());
		mlog.setOsVersion(sData.getOsVer());
		
		return mlog;
		
	}
	
	public static deal_log dData() throws Exception{

		System.out.println("ProducerAvro deal_log.");
		
		deal_log dlog = new deal_log();		
		SourceData sData = new SourceData();
		
		dlog.setDDm(sData.getDealDm());
		dlog.setLogId(sData.getLogID());
		dlog.setLogDtm(sData.getLogDtm());
		dlog.setRtCode(sData.getRandRtCode());
		dlog.setCustId(sData.getCustID());
		dlog.setDTxt(sData.getDealTxt());
						
		return dlog;
		
	}

}

