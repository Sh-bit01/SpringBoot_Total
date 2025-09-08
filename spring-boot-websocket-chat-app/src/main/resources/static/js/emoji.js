// emoji.js
$(function() {
  // Initialize emoji picker for the input field
  window.emojiPicker = new EmojiPicker({
    emojiable_selector: '#message',
    assetsPath: 'https://cdnjs.cloudflare.com/ajax/libs/emoji-picker/1.3.0/img/',
    popupButtonClasses: '' // remove auto button
  });
  window.emojiPicker.discover();

  // Create our own button to trigger the picker
  $('#emoji-button').on('click', function(e) {
    e.preventDefault();
    const $pickerButton = $('.emoji-picker-icon'); // the hidden button added by emoji-picker
    if ($pickerButton.length) {
      $pickerButton.first().click(); // trigger the emoji popup
    }
  });
});
