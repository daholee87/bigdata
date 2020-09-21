package exampleKafka;

import java.util.ArrayList;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.AlterTableOptions;
import org.apache.kudu.client.Client;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.GetTableSchemaRequest;
import org.apache.kudu.client.Insert;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.client.KuduSession;
import org.apache.kudu.client.KuduTable;
import org.apache.kudu.client.KuduTableStatistics;
import org.apache.kudu.client.ListTablesResponse;
import org.apache.kudu.client.PartialRow;

public class KuduTableSchema {

	final static Double DEFAULT_DOUBLE = 12.345;
	final static String KUDU_MASTERS = System.getProperty("kuduMasters", "hjlee:7051");
	
	public static void main(String[] args) {
   
	    KuduClient client = new KuduClient.KuduClientBuilder(KUDU_MASTERS).build();

	    try {
	    		createMLogTable(client);
	    		createDLogTable(client);

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	static void createMLogTable(KuduClient client)  throws KuduException {
		
		String tableName = "tb_mlog"; //모바일로그 테이블
					
		    List<ColumnSchema> columns = new ArrayList<>(8);
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("log_id", Type.STRING).nullable(true)//로그ID
		        .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("cust_id", Type.STRING)//사용자ID
		    	.key(true)
		    	.build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("log_dtm", Type.UNIXTIME_MICROS).nullable(true)//로그일시
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("m_id", Type.STRING).nullable(true)//기기ID
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("ip_addr", Type.STRING).nullable(true)//원격ID
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("os_type", Type.STRING).nullable(true)//OS유형
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("os_version", Type.STRING).nullable(true)//OS버전
		    	.build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("ls_ch_dtm", Type.UNIXTIME_MICROS).nullable(true)//최종변경일시
		 	    .build());
		    
		    Schema schema = new Schema(columns);
		    
		    CreateTableOptions cto = new CreateTableOptions();
		    List<String> hashKeys = new ArrayList<>(1);
		    hashKeys.add("key");
		    int numBuckets = 8;
		    cto.addHashPartitions(hashKeys, numBuckets);
		    cto.setNumReplicas(1);

		    // Create the table.
		    client.createTable(tableName, schema, cto);
		    System.out.println("Created table " + tableName);
		}
	
	static void createDLogTable(KuduClient client)  throws KuduException {

		String tableName = "tb_dlog"; //모바일로그 테이블

			
			List<ColumnSchema> columns = new ArrayList<>(7);
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("d_dm", Type.STRING).nullable(true)//거래일자
		        .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("log_id", Type.STRING).nullable(true)//로그ID
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("log_dtm", Type.UNIXTIME_MICROS).nullable(true)//로그일시
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("rt_code", Type.STRING).nullable(true)//처리결과코드
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("cust_id", Type.STRING)//사용자ID
		    	.key(true)
		    	.build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("d_txt", Type.STRING).nullable(true)//거래내용
			    .build());
		    columns.add(new ColumnSchema.ColumnSchemaBuilder("ls_ch_dtm", Type.UNIXTIME_MICROS).nullable(true)//최종변경일시
				 .build());		 
		    
		    Schema schema = new Schema(columns);	
		    
		    CreateTableOptions cto = new CreateTableOptions();
		    List<String> hashKeys = new ArrayList<>(1);
		    hashKeys.add("key");
		    int numBuckets = 8;
		    cto.addHashPartitions(hashKeys, numBuckets);
		    cto.setNumReplicas(1);

		    // Create the table.
		    client.createTable(tableName, schema, cto);
		    System.out.println("Created table " + tableName);

		}
		
	static void insertRows(KuduClient client, String tableName, int numRows) throws KuduException {
	    KuduTable table = client.openTable(tableName);
	    KuduSession session = client.newSession();
	    for (int i = 0; i < numRows; i++) {
	      Insert insert = table.newInsert();
	      PartialRow row = insert.getRow();
	      row.addInt("key", i);

	      if (i % 2 == 0) {
	        row.setNull("value");
	      } else {
	        row.addString("value", "value " + i);
	      }
	      session.apply(insert);
	    }
	}	

}

