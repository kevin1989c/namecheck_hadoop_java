	 
	import java.io.IOException;
	import java.util.StringTokenizer;
	 
	import org.apache.hadoop.conf.Configuration;
	import org.apache.hadoop.fs.Path;
	import org.apache.hadoop.io.IntWritable;
    import org.apache.hadoop.io.LongWritable;
    import org.apache.hadoop.io.Text;
	import org.apache.hadoop.mapreduce.Job;
	import org.apache.hadoop.mapreduce.Mapper;
	import org.apache.hadoop.mapreduce.Reducer;
	import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
	import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
	import org.apache.hadoop.util.GenericOptionsParser;

    import com.opencsv.CSVParser;


	 
	public class NameCheck {
		static String java = null;
	 
	  public static void main(String[] args) throws Exception {
		    System.out.println("please def the output file");
		    inputString typeInOut = new inputString();
		    typeInOut.runInput();
		    String outfile = typeInOut.io;
		  
	    Configuration conf = new Configuration();
	    String[] otherArgs=new String[]{"input",outfile}; 
	    if (otherArgs.length != 2) {
	      System.err.println("Usage: wordcount <in> <out>");
	      System.exit(2);
	    }
		 

	    System.out.println("please type the query word");
	    inputString typeIn = new inputString();
			typeIn.runInput();
			java=typeIn.io;

	    
	        
	    Job job = new Job();
	    job.setJarByClass(NameCheck.class);
	    job.setMapperClass(SongMapper.class);
	    job.setReducerClass(SongReducer.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
	    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	    
	    
	    
	    
	    
			
	    
	  }
	}


