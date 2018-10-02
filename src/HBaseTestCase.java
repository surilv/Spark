import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;


public class HBaseTestCase {

	static Configuration cfg=HBaseConfiguration.create();
	public static String ip = "192.168.19.133";
	
	 public static void creat(String tablename,String columnFamily) throws Exception {
		 cfg.set("hbase.zookeeper.quorum", ip);
	        HBaseAdmin admin = new HBaseAdmin(cfg);
	        
	        if (admin.tableExists(tablename)) {
	            System.out.println("table Exists!");
	            System.exit(0);
	        }
	        else{
	            @SuppressWarnings("deprecation")
				HTableDescriptor tableDesc = new HTableDescriptor(tablename);
	            tableDesc.addFamily(new HColumnDescriptor(columnFamily));
	            admin.createTable(tableDesc);
	            System.out.println("create table success!");
	        }
	    }
	 
	 public static void  main (String [] agrs) {
	    	String tablename="hbase_tb";
	    	String columnFamily="cf";
	    	
	    	try {  
	    		System.out.println("Hello Word!!!");
	    		HBaseTestCase.creat(tablename, columnFamily);
	    		//cfg.set("hbase.zookeeper.quorum", "192.168.19.131");
	    		//cfg.set("hbase.regionserver.ipc.address","192.168.19.131");
	    		//HBaseAdmin.checkHBaseAvailable(cfg);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }    
	}
	 
}
