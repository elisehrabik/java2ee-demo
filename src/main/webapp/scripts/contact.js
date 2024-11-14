$(document).ready(function() {
    $('.serverForm').submit(function(event) {
        // Disable all submit buttons
        $('.submit-btn').prop('disabled', true);
        // Add a spinner icon to the button that was clicked
        $('.submit-btn').html('<i class="fa-solid fa-circle-notch fa-spin"></i> Sending…');
    });
});