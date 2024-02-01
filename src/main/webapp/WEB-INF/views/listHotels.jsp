<%@ include file="header.jsp" %>
<!-- Body Wrapper -->
<div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <!-- Sidebar Start -->
    <%@ include file="aside.jsp" %>
    <!-- Sidebar End -->
    <!-- Main wrapper -->
    <div class="body-wrapper">
        <!-- Header Start -->
        <%@ include file="subHeader.jsp" %>
        <!-- Header End -->
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title fw-semibold mb-4">List Room</h5>
                        <div class="card">
                            <div class="card-body">
                                <div class="mb-3">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                            	<th>Room Id</th>
                                                <th>Room Name</th>
                                                <th>Category</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody id="hotelList">
                                            <!-- Hotel list will be dynamically added here -->
                                        </tbody>
                                    </table>
                                </div>
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

<script>
    $(document).ready(function () {
        // Fetch hotel data from the "getHotelData" URL
        $.ajax({
            url: 'getHotelData',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // Build the hotel list dynamically
                var hotelListHtml = '';
                $.each(data.data, function (index, hotel) {
                    hotelListHtml += '<tr>';
                    hotelListHtml += '<td>' + hotel.uniqueId + '</td>';
                    hotelListHtml += '<td>' + hotel.roomName + '</td>';
                    hotelListHtml += '<td>' + hotel.roomCategory + '</td>';
                    // Add more details as needed
                    hotelListHtml += '<td><button class="btn btn-primary" onclick="editHotel(' + hotel.id + ')">Edit</button></td>';
                    hotelListHtml += '<td><button class="btn btn-danger" onclick="deleteHotel(' + hotel.id + ')">Delete</button></td>';
                    hotelListHtml += '</tr>';
                });

                // Append the hotel list to the table body
                $('#hotelList').html(hotelListHtml);
            },
            error: function (error) {
                console.log('Error fetching hotel data: ', error);
            }
        });
        
    });
    
    function editHotel(hotelId) {
        // Redirect to the edit page with the selected hotel ID
        window.location.href = 'editHotel?id=' + hotelId;
    }
    
    function deleteHotel(hotelId) {
        // Perform delete operation or show a confirmation modal
        // You can use AJAX to delete the hotel or display a confirmation modal before deletion
        // Example:
         $.ajax({
             url: 'deleteRoomData?id=' + hotelId,
             type: 'GET',
             success: function (response) {
                 // Handle success
                 alert('Room Data Deleted successfully');
             },
             error: function (error) {
                 // Handle error
                 alert('Error Deleting Room Data: ', error);
             }
         });
    }
</script>
</body>
</html>
