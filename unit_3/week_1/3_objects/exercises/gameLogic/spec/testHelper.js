var hideTests = function() {
  $('#mocha').hide();
  $('#hide').text('Show Tests');
  $('#hide').off('click', hideTests);
  $('#hide').on('click', showTests);
};

var showTests = function() {
  $('#mocha').show();
  $('#hide').text('Hide Tests');
  $('#hide').off('click', showTests);
  $('#hide').on('click', hideTests);
};
