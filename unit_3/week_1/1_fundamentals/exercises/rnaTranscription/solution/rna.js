var toRna = function(nucleo){
  var rna = '';
  for (var i = 0 ; i < nucleo.length ; i++) {
    switch (nucleo[i]) {
      case 'C' :
        rna += 'G'
        break;
      case 'G' :
        rna += 'C'
        break;
      case 'A' :
        rna += 'U'
        break;
      case 'T' :
        rna += 'A'
        break;
      default :
    }
  }
  return rna;
};