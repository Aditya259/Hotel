package com.green.valley.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.valley.model.Hotel;
import com.green.valley.model.Response;
import com.green.valley.model.ResponseListData;
import com.green.valley.repository.HotelRepository;
import com.green.valley.utils.Constants;
import com.green.valley.utils.Utils;

@Controller
public class UserAppHomeController {

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	Utils utils;

	@PostMapping(value = "saveHotelData", consumes = "multipart/form-data")
	public String saveHotelData(@RequestParam("roomCategory") String roomCategory,
			@RequestParam("roomAvailable") String roomAvailable, @RequestParam("roomName") String roomName,
			@RequestParam("roomSize") String roomSize, @RequestParam("roomDescription") String roomDescription,
			@RequestParam("roomRating") String roomRating,
			@RequestParam(name = "roomReview", required = false) String roomReview,
			@RequestParam("roomPrice") String roomPrice, @RequestParam("roomDiscountPrice") String roomDiscountPrice,
			@RequestParam(name = "noOfAdult", required = false) String noOfAdult,
			@RequestParam("noOfRooms") String noOfRooms, @RequestParam("roomImageFile") MultipartFile roomImageFile,
			@RequestParam("roomImagePrimaryFile") MultipartFile roomImagePrimaryFile,
			@RequestParam("roomImageSecoundaryFile") MultipartFile roomImageSecoundaryFile,
			@RequestParam("roomThumbnailFile") MultipartFile roomThumbnailFile, Model model) {
		Response<Hotel> response = new Response<Hotel>();
		Hotel hotel = new Hotel();
		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		if (hotel != null) {
			try {
				response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
				response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
				response.setMessage("Saved Successfully");
				File dir = new File(Constants.UPLOAD_DIR);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String roomImageFileName = UUID.randomUUID().toString() + "_" + roomImageFile.getOriginalFilename();
				String roomImagePrimaryFileName = UUID.randomUUID().toString() + "_"
						+ roomImagePrimaryFile.getOriginalFilename();
				String roomImageSecondaryFileName = UUID.randomUUID().toString() + "_"
						+ roomImageSecoundaryFile.getOriginalFilename();
				String roomThumbnailFileName = UUID.randomUUID().toString() + "_"
						+ roomThumbnailFile.getOriginalFilename();
				// Save the files to the specified directory
				roomImageFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImageFileName));
				roomImagePrimaryFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImagePrimaryFileName));
				roomImageSecoundaryFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImageSecondaryFileName));
				roomThumbnailFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomThumbnailFileName));
				// Set the file paths in the Hotel object
				hotel.setRoomCategory(roomCategory);
				hotel.setRoomImage(Constants.UPLOAD_DIR + roomImageFileName);
				hotel.setRoomImagePrimary(Constants.UPLOAD_DIR + roomImagePrimaryFileName);
				hotel.setRoomImageSecoundary(Constants.UPLOAD_DIR + roomImageSecondaryFileName);
				hotel.setRoomThumbnail(Constants.UPLOAD_DIR + roomThumbnailFileName);
				hotel.setRoomAvailable(roomAvailable);
				hotel.setRoomName(roomName);
				hotel.setRoomSize(roomSize);
				hotel.setRoomDescription(roomDescription);
				hotel.setRoomRating(roomRating);
				hotel.setRoomReview(roomReview);
				hotel.setRoomPrice(roomPrice);
				hotel.setRoomDiscountPrice(roomDiscountPrice);
				hotel.setNoOfAdult(noOfAdult);
				hotel.setNoOfRooms(noOfRooms);
				hotel.setUniqueId(utils.fourDigitRandom());
				hotel.setCreatedBy(1);
				hotel.setCreatedDt(new Date());
				hotel.setUpdatedBy(1);
				hotel.setUpdatedDt(new Date());
				Hotel hotelResp = hotelRepository.save(hotel);
				response.setData(hotelResp);
			} catch (IOException e) {
				e.printStackTrace();
				response.setMessage("Error saving files. Please try again.");
			}
		}
		model.addAttribute("statusCode", response.getStatusCode());
		model.addAttribute("status", response.getStatus());
		model.addAttribute("message", response.getMessage());
		model.addAttribute("statusCode", response.getStatusCode());
		return "response";
	}

	@PostMapping(value = "editHotelData", consumes = "multipart/form-data")
	public String editHotelData(@RequestParam("id") int id, @RequestParam("roomCategory") String roomCategory,
			@RequestParam("roomAvailable") String roomAvailable, @RequestParam("roomName") String roomName,
			@RequestParam("roomSize") String roomSize, @RequestParam("roomDescription") String roomDescription,
			@RequestParam("roomRating") String roomRating,
			@RequestParam(name = "roomReview", required = false) String roomReview,
			@RequestParam("roomPrice") String roomPrice, @RequestParam("roomDiscountPrice") String roomDiscountPrice,
			@RequestParam(name = "noOfAdult", required = false) String noOfAdult,
			@RequestParam("noOfRooms") String noOfRooms,
			@RequestParam(name = "roomImageFile", required = false) MultipartFile roomImageFile,
			@RequestParam(name = "roomImagePrimaryFile", required = false) MultipartFile roomImagePrimaryFile,
			@RequestParam(name = "roomImageSecoundaryFile", required = false) MultipartFile roomImageSecoundaryFile,
			@RequestParam(name = "roomThumbnailFile", required = false) MultipartFile roomThumbnailFile, Model model) {
		Response<Hotel> response = new Response<Hotel>();
		// Hotel hotel = new Hotel();
		Optional<Hotel> hotelData = hotelRepository.findById(id);

		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		if (hotelData.get() != null) {
			try {
				response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
				response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
				response.setMessage("Saved Successfully");
				File dir = new File(Constants.UPLOAD_DIR);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				if (roomImageFile != null) {
					String roomImageFileName = UUID.randomUUID().toString() + "_" + roomImageFile.getOriginalFilename();
					roomImageFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImageFileName));
					hotelData.get().setRoomImage(Constants.UPLOAD_DIR + roomImageFileName);

				}
				if (roomImagePrimaryFile != null) {
					String roomImagePrimaryFileName = UUID.randomUUID().toString() + "_"
							+ roomImagePrimaryFile.getOriginalFilename();
					roomImagePrimaryFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImagePrimaryFileName));
					hotelData.get().setRoomImagePrimary(Constants.UPLOAD_DIR + roomImagePrimaryFileName);

				}
				if (roomImageSecoundaryFile != null) {
					String roomImageSecondaryFileName = UUID.randomUUID().toString() + "_"
							+ roomImageSecoundaryFile.getOriginalFilename();
					roomImageSecoundaryFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomImageSecondaryFileName));
					hotelData.get().setRoomImageSecoundary(Constants.UPLOAD_DIR + roomImageSecondaryFileName);

				}
				if (roomThumbnailFile != null) {
					String roomThumbnailFileName = UUID.randomUUID().toString() + "_"
							+ roomThumbnailFile.getOriginalFilename();
					roomThumbnailFile.transferTo(new File(Constants.UPLOAD_DIR + "/" + roomThumbnailFileName));
					hotelData.get().setRoomThumbnail(Constants.UPLOAD_DIR + roomThumbnailFileName);

				}
				// Set the file paths in the Hotel object

				hotelData.get().setRoomCategory(roomCategory);
				hotelData.get().setRoomAvailable(roomAvailable);
				hotelData.get().setRoomName(roomName);
				hotelData.get().setRoomSize(roomSize);
				hotelData.get().setRoomDescription(roomDescription);
				hotelData.get().setRoomRating(roomRating);
				hotelData.get().setRoomReview(roomReview);
				hotelData.get().setRoomPrice(roomPrice);
				hotelData.get().setRoomDiscountPrice(roomDiscountPrice);
				hotelData.get().setNoOfAdult(noOfAdult);
				hotelData.get().setNoOfRooms(noOfRooms);
				hotelData.get().setUniqueId(utils.fourDigitRandom());
				hotelData.get().setCreatedBy(1);
				hotelData.get().setCreatedDt(new Date());
				hotelData.get().setUpdatedBy(1);
				hotelData.get().setUpdatedDt(new Date());
				Hotel hotelResp = hotelRepository.save(hotelData.get());
				response.setData(hotelResp);
			} catch (IOException e) {
				e.printStackTrace();
				response.setMessage("Error saving files. Please try again.");
			}
		}
		model.addAttribute("statusCode", response.getStatusCode());
		model.addAttribute("status", response.getStatus());
		model.addAttribute("message", response.getMessage());
		model.addAttribute("statusCode", response.getStatusCode());
		return "response";
	}

	@GetMapping("getHotelData")
	@ResponseBody
	public ResponseListData<Hotel> getHotelData() {
		ResponseListData<Hotel> response = new ResponseListData<Hotel>();
		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
		response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
		response.setMessage("Saved Successfully");
		List<Hotel> hotelResp = hotelRepository.findAll();
		response.setData(hotelResp);
		return response;
	}

	@GetMapping("/")
	public String loadAddHotel() {
		return "index";
	}

	@GetMapping("addHotel")
	public String addHotel() {
		return "addHotel";
	}

	@GetMapping("listHotel")
	public String listHotel() {
		return "listHotels";
	}

	@GetMapping("editHotel")
	public String editHotel(@RequestParam("id") int hotelId, Model model) {
		System.err.println(hotelId);
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);
		model.addAttribute("hotel", hotel.get());
		return "editHotel";
	}

	@GetMapping("/deleteRoomData")
	@ResponseBody
	public ResponseEntity<String> deleteHotel(@RequestParam("id") int hotelId) {
		try {
			// Call the service method to delete the hotel by ID
			hotelRepository.deleteById(hotelId);
			return ResponseEntity.ok("Hotel deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error deleting hotel: " + e.getMessage());
		}
	}

	@GetMapping("getAllRoomData")
	@ResponseBody
	@CrossOrigin(origins = "*") // Replace with your Angular app's domain and port
	public ResponseListData<Hotel> getAllRoomData() {
		ResponseListData<Hotel> response = new ResponseListData<Hotel>();
		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
		response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
		response.setMessage("Saved Successfully");
		List<Hotel> hotelResp = hotelRepository.findAll();

		response.setData(hotelResp);
		return response;
	}
	
	@GetMapping("getAllACRoomData")
	@ResponseBody
	@CrossOrigin(origins = "*") // Replace with your Angular app's domain and port
	public ResponseListData<Hotel> getAllACRoomData() {
		ResponseListData<Hotel> response = new ResponseListData<Hotel>();
		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
		response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
		response.setMessage("Saved Successfully");
		List<Hotel> hotelResp = hotelRepository.getAllACRoomData();

		response.setData(hotelResp);
		return response;
	}
	
	@GetMapping("getAllNonACRoomData")
	@ResponseBody
	@CrossOrigin(origins = "*") // Replace with your Angular app's domain and port
	public ResponseListData<Hotel> getAllNonACRoomData() {
		ResponseListData<Hotel> response = new ResponseListData<Hotel>();
		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
		response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
		response.setMessage("Saved Successfully");
		List<Hotel> hotelResp = hotelRepository.getAllNonACRoomData();

		response.setData(hotelResp);
		return response;
	}
	
	@GetMapping("getRoomDataById")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public Response<Hotel> getRoomDataById(@RequestParam("id") int id, Model model) {
		Response<Hotel> response = new Response<Hotel>();
		// Hotel hotel = new Hotel();
		Optional<Hotel> hotelData = hotelRepository.findById(id);

		response.setStatus(Constants.FAILED_RESPONSE_STATUS);
		response.setStatusCode(Constants.FAILED_RESPONSE_CODE);
		response.setMessage("Unable to Save Hotel Data. Please Contact Administrator");
		if (hotelData.get() != null) {
			response.setStatus(Constants.SUCCESS_RESPONSE_STATUS);
			response.setStatusCode(Constants.SUCCESS_RESPONSE_CODE);
			response.setMessage("Saved Successfully");
			
			response.setData(hotelData.get());
		}
		model.addAttribute("statusCode", response.getStatusCode());
		model.addAttribute("status", response.getStatus());
		model.addAttribute("message", response.getMessage());
		model.addAttribute("statusCode", response.getStatusCode());
		return response;
	}

}
