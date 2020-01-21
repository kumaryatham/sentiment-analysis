package com.altimetrik.sentimentanalysis.commonutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperationUtils {
	static Logger log = LoggerFactory.getLogger(FileOperationUtils.class);
	public static boolean createFile(String fileKeyword,FilePropertiesUtils fifilePathleOperationUtils) {
		FTPClient ftpclient=null;
		String FILE_NAME=fileKeyword+System.currentTimeMillis()+".txt";
		File file = new File(fifilePathleOperationUtils.getFilePath()+File.separator+FILE_NAME);
		boolean isFileUpload=false;
		 log.info("INSDIE Try ==> class : FileOperationUtils , Method : "
		     		+ "createFile() , the Keyword is "+fileKeyword +fifilePathleOperationUtils.getFilePath());
			
		try(FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(fw)) {

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
				log.info("INSDIE Try ==> class : FileOperationUtils , Method : "
			     		+ "createFile() , AbsoluteFile Name"+file.getAbsoluteFile());
			}
			// true = append file
			bw.write(fileKeyword);
			System.out.println("Done");
			
			//Connecting remote server by using FTP client
			ftpclient = ftpConnection(fifilePathleOperationUtils.getHostname(),fifilePathleOperationUtils.getUserName(),
					fifilePathleOperationUtils.getPassword());
			isFileUpload=uploadFile(file, FILE_NAME,fifilePathleOperationUtils.getHostDir(), ftpclient);
			
			if(isFileUpload) {
				log.info("INSDIE Try ==> class : FileOperationUtils , Method : "
			     		+ " createFile() try block"+isFileUpload);
				return isFileUpload;	
			}
		
		} catch (Exception e) {

			log.info("INSDIE Catch ==> class : FileOperationUtils , Method : "
		     		+ "createFile() catch block",e.getMessage());

		} finally {
			disconnect(ftpclient);
		}
		return isFileUpload;
	}


	public static FTPClient ftpConnection(String host, String user, String pwd) throws Exception{
		
		log.info("INSDIE ftpConnection ==> class : FileOperationUtils , Method : "+
	     		 "createFile() ===> ftpConnection () Enter");
		
		FTPClient ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		log.info("INSDIE ftpConnection ==> class : FileOperationUtils , Method : "+
	     		 "createFile() ===> ftpConnection () Exit ==> IsConnected :"+ftp.isConnected());
		
		return ftp;
	}
	
	public static boolean uploadFile(File localFileFullName, String fileName, String hostDir,FTPClient ftpClient)
			throws Exception {
		boolean isUpload=false;
		if(ftpClient != null) {
		log.info("INSDIE uploadFile ==> class : FileOperationUtils , Method : "+
	     		 "createFile() ==> uploadFile () Enter ==> IsConnected :"+ftpClient.isConnected());
		
		try(InputStream input = new FileInputStream(localFileFullName)){
			isUpload=ftpClient.storeFile(hostDir + fileName, input);
			log.info("INSDIE uploadFile ==> try ==> class : FileOperationUtils , Method : "+
		     		 "createFile() ==> uploadFile () Enter ==> IsUploaded :"+ isUpload);
			return isUpload;
		}catch(Exception e) {
			log.error("INSDIE catch ==> uploadFile ==> class : FileOperationUtils , Method : "+
		     		 "createFile() ==> uploadFile () Enter ==> IsUploaded :", e.getMessage());
		}
		}
	    return isUpload;
	}
	public static void disconnect(FTPClient ftp){
		log.info("INSDIE disconnect ==> class : FileOperationUtils , Method : "+
	     		 "createFile() ==> disconnect () Enter ==> Disconnect :"+ftp.isConnected());
		if (ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
				log.info("INSDIE disconnect ==>try  ==> class : FileOperationUtils , Method : "+
			     		 "createFile() ==> disconnect () Enter ==> Disconnect :"+ ftp.isConnected());
			} catch (IOException fe) {
				log.error("INSDIE disconnect ==> catch ==> uploadFile ==> class : FileOperationUtils , Method : "+
			     		 "createFile() ==> disconnect () Enter ==> Disconnect :", fe.getMessage());
			}
		}
	}


	
}
