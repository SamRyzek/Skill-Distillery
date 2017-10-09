describe(``, function() {
  describe(`1 : Create an array literal named 'classArray' ...`, function(){
    it(`classArray is defined`,function(){
      expect(classArray).to.be.defined;
    });
    it(`classArray has items in it`,function(){
      expect(classArray.length).to.be.above(5);
    });
  });
  describe(`2 : Evaluate the following 'shuffle' function ...`, function(){
    it(`returns an array`, function() {
      expect(Array.isArray(shuffle(['apple', 'banana', 'coconut']))).to.be.true;
    });
  });
  describe(`3 : Create a function named 'makeGroupsOfNumFromArray' ...`, function(){
    it(`makeGroupsOfNumFromArray is defined`, function(){
      expect(makeGroupsOfNumFromArray).to.be.defined;
    });
    it(`makeGroupsOfNumFromArray is a function`, function(){
      expect(typeof makeGroupsOfNumFromArray).to.equal('function');
    });
    it(`makeGroupsOfNumFromArray returns an array of arrays`, function(){
      expect(Array.isArray(makeGroupsOfNumFromArray(2, ['apple', 'banana',
        'coconut', 'date','eucalyptus','fig'])[0])).to.be.true;
    });
    it(`makeGroupsOfNumFromArray returns an array of the specified length`, function(){
      expect(makeGroupsOfNumFromArray(2, ['apple', 'banana',
        'coconut', 'date','eucalyptus','fig'])[0].length).to.equal(2);
    });
  });
});
