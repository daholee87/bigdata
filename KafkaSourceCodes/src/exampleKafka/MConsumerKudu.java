package exampleKafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.*;

import org.apache.kudu.client.*;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

import AvroSchema.mobile_log;

public class MConsumerKudu {
	
	public static void main(String[] args) throws Exception {
		
		String mTopicName = "mlog"; //모바일로그 토픽
		String dTopicName = "dlog"; //거래로그 토픽
		
		// Set up client Java properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
        
		properties.put("zookeeper.connect","localhost:2181,localhost:2182,localhost:2183");
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true"); //auto offset commit 활성화
		properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());		
		properties.put("group.id","testgroup");
		properties.put("auto.commit.interval.ms", "60000"); //default 값
		properties.put("fetch.message.max.bytes", "31457280"); // 30MB  
			
		try(KafkaConsumer<String,byte[]> consumer = new KafkaConsumer<>(properties)){            	
        	consumer.subscribe(Arrays.asList(mTopicName));//모바일로그 토픽 구독
            SpecificDatumReader<mobile_log> SpecificDatumReader = new SpecificDatumReader<mobile_log>(mobile_log.class);

            while(true){
            	try {                
            			ConsumerRecords<String, byte[]> records = consumer.poll(100);
                 
            			for(ConsumerRecord<String, byte[]> record : records) {                    	
            				BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(record.value(), null);       	                        
            				mobile_log read = SpecificDatumReader.read(null, binaryDecoder);                     
            				System.out.println("Message from Topic("+mTopicName+") : " + read.toString());                            					
            			}                    

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
		}
	}

}
