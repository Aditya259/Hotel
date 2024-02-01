<%@ page import="com.green.valley.model.Hotel" %>

<%@ include file="header.jsp" %>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <!-- Sidebar Start -->
     <%@ include file="aside.jsp" %>
    <!--  Sidebar End -->
    <!--  Main wrapper -->
    <div class="body-wrapper">
      <!--  Header Start -->
      <%@ include file="subHeader.jsp" %>
      <!--  Header End -->
      <div class="container-fluid">
        <div class="container-fluid">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title fw-semibold mb-4">Edit Room</h5>
              <div class="card">
                <div class="card-body">
                <%Hotel hotel = (Hotel)request.getAttribute("hotel");
                System.out.println(hotel);%>
                  <form action="editHotelData" method="post" enctype="multipart/form-data">
                  
                  <input type="hidden" value="<%=hotel.getId() %>" name="id">
                  
                    <div class="mb-3">
                      <label for="exampleInputRoomCat" class="form-label">Hotel Category</label>
                      <select class="form-control" id="exampleInputRoomCat" name="roomCategory" required>
						    <option value="" disabled="disabled" <% if (hotel.getRoomCategory() == null || hotel.getRoomCategory().isEmpty()) { %> selected <% } %>>Select Category</option>
						    <option value="AC" <% if ("AC".equals(hotel.getRoomCategory())) { %> selected <% } %>>AC</option>
						    <option value="NONAC" <% if ("NONAC".equals(hotel.getRoomCategory())) { %> selected <% } %>>NON AC</option>
						</select>

                      <div id="emailHelp" class="form-text">AC / NON-AC</div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomName" class="form-label">Room Name</label>
                      <input type="text" class="form-control" id="exampleInputRoomName" value="<%=hotel.getRoomName() %>" name="roomName" required>
                      <div id="emailHelp" class="form-text">Delux / Single / Double </div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomSize" class="form-label">Room Size</label>
                      <input type="text" class="form-control" id="exampleInputRoomSize" value="<%=hotel.getRoomSize() %>" name="roomSize" required>
                      <div id="emailHelp" class="form-text">2 Adult / 4 Adult / 2 Adult 1 Child </div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomDescription" class="form-label">Room Description</label>
                      <textarea class="form-control" id="exampleInputRoomDescription" name="roomDescription" required>
                      <%=hotel.getRoomDescription() %> 
                      </textarea>
                      <div id="emailHelp" class="form-text">Room having 1 king size Bed with well furnished... </div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomRating" class="form-label">Room Rating</label>
                      <input type="text"  class="form-control" id="exampleInputRoomRating" value="<%=hotel.getRoomRating() %>" name="roomRating" required>
                      
                      <div id="emailHelp" class="form-text">3.5 / 4.5 / 5 </div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomPrice" class="form-label">Room Price</label>
                      <input type="text"  class="form-control" id="exampleInputRoomPrice" value="<%=hotel.getRoomPrice() %>" name="roomPrice" required>
                      
                      <div id="emailHelp" class="form-text">&#x20B9; 1200 per night </div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomDiscountPrice" class="form-label">Room Discount Price</label>
                      <input type="text"  class="form-control" id="exampleInputRoomDiscountPrice" value="<%=hotel.getRoomDiscountPrice() %>" name="roomDiscountPrice" required>
                      
                      <div id="emailHelp" class="form-text">&#x20B9; 1000 per night </div>
                    </div>
                    
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomNoOfRooms" class="form-label">Number Of Rooms</label>
                      <input type="text"  class="form-control" id="exampleInputRoomNoOfRooms" value="<%=hotel.getNoOfRooms() %>" name="noOfRooms" required>
                      
                      <div id="emailHelp" class="form-text">2 / 3 </div>
                    </div>
                    
                     <div class="mb-3">
                      <label for="exampleInputRoomAvailable" class="form-label">Room Available</label>
                      <input type="text"  class="form-control" id="exampleInputRoomAvailable" value="<%=hotel.getRoomAvailable() %>" name="roomAvailable" required>
                      
                      <div id="emailHelp" class="form-text">Available / Sold Out</div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomImage" class="form-label">Room Image</label>
				        <input type="file" class="form-control" id="exampleInputRoomImage" name="roomImageFile" accept="image/*" >
                      <div id="emailHelp" class="form-text">Room Image </div>
                    </div>
                    
                     <div class="mb-3">
                      <label for="exampleInputRoomImagePrimary" class="form-label">Room Image Primary</label>
				        <input type="file" class="form-control" id="exampleInputRoomImagePrimary" name="roomImagePrimaryFile" accept="image/*" >
                      <div id="emailHelp" class="form-text">Room Image Primary</div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomImageSecondary" class="form-label">Room Image Secondary</label>
				        <input type="file" class="form-control" id="exampleInputRoomImageSecondary" name="roomImageSecoundaryFile" accept="image/*" >
                      <div id="emailHelp" class="form-text">Room Image Secondary</div>
                    </div>
                    
                    <div class="mb-3">
                      <label for="exampleInputRoomImageThumbnail" class="form-label">Room Image Thumbnail</label>
				        <input type="file" class="form-control" id="exampleInputRoomImageThumbnail" name="roomThumbnailFile" accept="image/*" >
                      <div id="emailHelp" class="form-text">Room Image Thumbnail</div>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
                </div>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="../assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="../assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../assets/js/sidebarmenu.js"></script>
  <script src="../assets/js/app.min.js"></script>
  <script src="../assets/libs/simplebar/dist/simplebar.js"></script>
</body>

</html>