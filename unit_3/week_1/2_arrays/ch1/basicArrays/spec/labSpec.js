describe(`Basic Arrays Lab`,function(){
  describe(`1 : Create an array literal in a variable named 'testArray' ...`,function(){
    it(`testArray is defined`, function() {
      expect(testArray).to.be.defined;
    });
    it(`contains [0,1,2,3,4,5,6,7,8,9,10]`, function() {
      expect(testArray).to.include.members([0,1,2,3,4,5,6,7,8,9,10]);
    });
    it(`contains ['apple','banana','coconut']`, function() {
      expect(testArray).to.include.members(['apple','banana','coconut']);
    });
    it(`is length 16`, function() {
      expect(testArray.length).to.equal(16)
    })
  });
  describe(`2 : Write a function expression named 'countElements' ...`,function(){
    it(`countElements is defined`, function() {
      expect(countElements).to.be.defined;
    });
    it(`countElements is a function`, function() {
      expect(typeof countElements).to.equal('function');
    });
    it(`countElements returns the correct length`, function() {
      expect(countElements([1,2,3,4])).to.equal([1,2,3,4].length);
    });
  });
  describe(`3 : Write a function expression named 'countType' ...`,function(){
    it(`countType is defined`, function() {
      expect(countType).to.be.defined;
    });
    it(`countType is a function`, function() {
      expect(typeof countType).to.equal('function');
    });
    it(`returns the correct count of a type`, function() {
      expect(countType([1,2,3,4,'apple'], 'number')).to.equal(4);
      expect(countType([1,2,3,4,'apple'], 'string')).to.equal(1);
      expect(countType([1,2,3,4,'apple', NaN, NaN], 'number')).to.equal(6);
      expect(countType([{},{},[],'apple'], 'object')).to.equal(3);
    });
  });
  describe(`4 : Write a function expression named 'countTypeWithFunction' ...`,function(){
    it(`countTypeWithFunction is defined`, function() {
      expect(countTypeWithFunction).to.be.defined;
    });
    it(`countTypeWithFunction is a function`, function() {
      expect(typeof countTypeWithFunction).to.equal('function');
    });
    it(`isRealNumber is defined`, function() {
      expect(isRealNumber).to.be.defined;
    });
    it(`isRealNumber is a function`, function() {
      expect(typeof isRealNumber).to.equal('function');
    });
    it(`correctly counts numbers (ignoring NaN)`, function() {
      expect(countTypeWithFunction(testArray, isRealNumber)).to.equal(11);
    });
    it(`isString is defined`, function() {
      expect(isString).to.be.defined;
    });
    it(`isString is a function`, function() {
      expect(typeof isString).to.equal('function');
    });
    it(`correctly counts strings`, function() {
      expect(countTypeWithFunction(testArray, isString)).to.equal(3);
    });
    it(`isUndefined is defined`, function() {
      expect(isUndefined).to.be.defined;
    });
    it(`isUndefined is a function`, function() {
      expect(typeof isUndefined).to.equal('function');
    });
    it(`correctly counts undefined values`, function() {
      expect(countTypeWithFunction(testArray, isUndefined)).to.equal(1);
    });
  });
  describe(`5 : Create a function expression named 'concurrentModification' ...`,function(){
    it(`concurrentModification is defined`, function() {
      expect(concurrentModification).to.be.defined;
    });
    it(`concurrentModification is a function`, function() {
      expect(typeof concurrentModification).to.equal('function');
    });
    it(`returns an array free of real numbers, but containing the other values`, function() {
      expect(concurrentModification(testArray, isRealNumber).length).to.equal(5);
    });
  });
});


