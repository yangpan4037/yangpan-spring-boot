package site.yangpan.mongodb.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FileEntity 文档类.
 * Created by yangpan on 2019-07-18 23:53.
 */
@Document
public class FileEntity {

	@Id
	private String fileId;
    private String fileName;
    private String contentType;
    private long size;
    private Date uploadDate;
    private String md5;
    private byte[] content;
    private String path;
    
    public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}


	public Date getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}


	public String getMd5() {
		return md5;
	}


	public void setMd5(String md5) {
		this.md5 = md5;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}

    
    protected FileEntity() {
    }
    
    public FileEntity(String fileName, String contentType, long size, byte[] content) {
    	this.fileName = fileName;
    	this.contentType = contentType;
    	this.size = size;
    	this.uploadDate = new Date();
    	this.content = content;
    }
   
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FileEntity fileEntityInfo = (FileEntity) object;
        return java.util.Objects.equals(size, fileEntityInfo.size)
                && java.util.Objects.equals(fileName, fileEntityInfo.fileName)
                && java.util.Objects.equals(contentType, fileEntityInfo.contentType)
                && java.util.Objects.equals(uploadDate, fileEntityInfo.uploadDate)
                && java.util.Objects.equals(md5, fileEntityInfo.md5)
                && java.util.Objects.equals(fileId, fileEntityInfo.fileId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fileName, contentType, size, uploadDate, md5, fileId);
    }
}
