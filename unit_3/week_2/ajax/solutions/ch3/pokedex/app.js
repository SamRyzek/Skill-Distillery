$(document).ready(function(){
  init();
});

var init = function(){
  DataService.index(Display.buildTable);
}
