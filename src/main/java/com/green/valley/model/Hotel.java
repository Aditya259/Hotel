package com.green.valley.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int uniqueId;
	private String roomCategory;
	private String roomName;
	private String roomSize;
	private String roomDescription;
	private String roomRating;
	private String roomReview;
	private String roomPrice;
	private String roomDiscountPrice;
	private String roomImage;
	private String roomImagePrimary;
	private String roomImageSecoundary;
	private String roomThumbnail;
	private String noOfAdult;
	private String noOfRooms;
	private int createdBy;
	private Date createdDt;
	private int updatedBy;
	private Date updatedDt;
	private String roomAvailable;
	private transient MultipartFile roomImageFile;
	private transient MultipartFile roomImagePrimaryFile;
	private transient MultipartFile roomImageSecoundaryFile;
	private transient MultipartFile roomThumbnailFile;

	public String getRoomAvailable() {
		return roomAvailable;
	}

	public void setRoomAvailable(String roomAvailable) {
		this.roomAvailable = roomAvailable;
	}

	public MultipartFile getRoomImageFile() {
		return roomImageFile;
	}

	public void setRoomImageFile(MultipartFile roomImageFile) {
		this.roomImageFile = roomImageFile;
	}

	public MultipartFile getRoomImagePrimaryFile() {
		return roomImagePrimaryFile;
	}

	public void setRoomImagePrimaryFile(MultipartFile roomImagePrimaryFile) {
		this.roomImagePrimaryFile = roomImagePrimaryFile;
	}

	public MultipartFile getRoomImageSecoundaryFile() {
		return roomImageSecoundaryFile;
	}

	public void setRoomImageSecoundaryFile(MultipartFile roomImageSecoundaryFile) {
		this.roomImageSecoundaryFile = roomImageSecoundaryFile;
	}

	public MultipartFile getRoomThumbnailFile() {
		return roomThumbnailFile;
	}

	public void setRoomThumbnailFile(MultipartFile roomThumbnailFile) {
		this.roomThumbnailFile = roomThumbnailFile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getRoomRating() {
		return roomRating;
	}

	public void setRoomRating(String roomRating) {
		this.roomRating = roomRating;
	}

	public String getRoomReview() {
		return roomReview;
	}

	public void setRoomReview(String roomReview) {
		this.roomReview = roomReview;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomDiscountPrice() {
		return roomDiscountPrice;
	}

	public void setRoomDiscountPrice(String roomDiscountPrice) {
		this.roomDiscountPrice = roomDiscountPrice;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public String getRoomImagePrimary() {
		return roomImagePrimary;
	}

	public void setRoomImagePrimary(String roomImagePrimary) {
		this.roomImagePrimary = roomImagePrimary;
	}

	public String getRoomImageSecoundary() {
		return roomImageSecoundary;
	}

	public void setRoomImageSecoundary(String roomImageSecoundary) {
		this.roomImageSecoundary = roomImageSecoundary;
	}

	public String getRoomThumbnail() {
		return roomThumbnail;
	}

	public void setRoomThumbnail(String roomThumbnail) {
		this.roomThumbnail = roomThumbnail;
	}

	public String getNoOfAdult() {
		return noOfAdult;
	}

	public void setNoOfAdult(String noOfAdult) {
		this.noOfAdult = noOfAdult;
	}

	public String getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", uniqueId=" + uniqueId + ", roomCategory=" + roomCategory + ", roomName="
				+ roomName + ", roomSize=" + roomSize + ", roomDescription=" + roomDescription + ", roomRating="
				+ roomRating + ", roomReview=" + roomReview + ", roomPrice=" + roomPrice + ", roomDiscountPrice="
				+ roomDiscountPrice + ", roomImage=" + roomImage + ", roomImagePrimary=" + roomImagePrimary
				+ ", roomImageSecoundary=" + roomImageSecoundary + ", roomThumbnail=" + roomThumbnail + ", noOfAdult="
				+ noOfAdult + ", noOfRooms=" + noOfRooms + ", createdBy=" + createdBy + ", createdDt=" + createdDt
				+ ", updatedBy=" + updatedBy + ", updatedDt=" + updatedDt + "]";
	}

}
