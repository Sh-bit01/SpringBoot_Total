'use strict';

$(function () {
  // Initialize emoji picker for the input field
  window.emojiPicker = new EmojiPicker({
    emojiable_selector: '#message',
    assetsPath: 'https://cdnjs.cloudflare.com/ajax/libs/emoji-picker/1.3.0/img/',
    popupButtonClasses: '' // remove auto button
  });
  window.emojiPicker.discover();

  // Create our own button to trigger the picker
  $('#emoji-button').on('click', function (e) {
    e.preventDefault();

    // Find the picker icon injected for #message
    const $pickerButton = $('#message').siblings('.emoji-picker-icon');

    if ($pickerButton.length) {
      $pickerButton.trigger('click'); // trigger the emoji popup
    } else {
      console.warn("Emoji picker button not found. Make sure EmojiPicker initialized correctly.");
    }
  });
});
