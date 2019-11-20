package com.lowes.bfcode.batch.writer;

import java.util.List;

import org.springframework.batch.item.database.JdbcBatchItemWriter;

public class CompositeItemWriter<T> extends JdbcBatchItemWriter<T> {

	JdbcBatchItemWriter<T> itemWriter;

    public CompositeItemWriter() {
		super();
		System.out.println("DB update done!");
		// TODO Auto-generated constructor stub
	}
    
    
	/*public CompositeItemWriter(JdbcBatchItemWriter<T> itemWriter) {
        this.itemWriter = itemWriter;
    }*/
 /*@Override
    public void write(List<? extends T> items) throws Exception {
        //Add business logic here
	 
       //itemWriter.write(items);
       
    }*/
    
    /*public void setDelegate(JdbcBatchItemWriter<T> itemWriter){
        this.itemWriter = itemWriter;
    }*/
}