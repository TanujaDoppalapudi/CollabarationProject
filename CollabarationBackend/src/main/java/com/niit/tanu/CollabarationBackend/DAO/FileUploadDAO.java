package com.niit.tanu.CollabarationBackend.DAO;

import com.niit.tanu.CollabarationBackend.Model.*;

public interface FileUploadDAO 
{
	public void save(FileUpload fileUpload, String username);
	public FileUpload getFile(String username);
}
