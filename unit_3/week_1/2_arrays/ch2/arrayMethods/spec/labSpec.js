describe(`Array Methods Test Suite`, function(){
  describe(`1 : Modify ex1 ...`, function(){
    it(`returns an array`, function(){
      expect(Array.isArray(ex1([1,2,3,4,NaN]))).to.be.true;
    });
    it(`removes NaN (converts it to a number)`, function(){
      expect(ex1([1,2,3,4,NaN]).length).to.equal(5);
      expect(ex1([1,2,3,4,NaN])).not.to.include.members([NaN]);
      expect(ex1([1,2,3,4,NaN])).to.include.members([5]);
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
  describe(`2 : Modify ex2 ...`, function(){
    it(`returns an array`, function(){
      expect(Array.isArray(ex2([1,2,3,4,NaN]))).to.be.true;
    });
    it(`removes NaN (converts it to 0)`, function(){
      expect(ex2([1,2,3,4,NaN]).length).to.equal(5);
      expect(ex2([1,2,3,4,NaN])).not.to.include.members([NaN]);
      expect(ex2([1,2,3,4,NaN])).to.include.members([0]);
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
  describe(`3 : Modify ex3 ...`, function(){
    it(`returns an array`, function(){
      expect(Array.isArray(ex3([1,2,3,4,NaN]))).to.be.true;
    });
    it(`removes NaN`, function(){
      expect(ex3([1,2,3,4,NaN]).length).to.equal(4);
      expect(ex3([1,2,3,4,NaN])).not.to.include.members([NaN]);
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
  describe(`4 : Modify ex4 ...`, function(){
    it(`returns a number`, function(){
      expect(typeof ex4([1,2,3,4,NaN])).to.equal('number');
    });
    it(`returns the provided numbers (less NaN) reversed and subtracted`, function(){
      expect(ex4([1,2,3,4,NaN])).to.equal(-2);
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
  describe(`5 : Modify ex5 ...`, function(){
    it(`returns an array`, function(){
      expect(Array.isArray(ex5([NaN,2,4,1,3]))).to.be.true;
    });
    it(`sorts the values in ascending order and places NaN at the end`, function(){
      expect(ex5([NaN,2,4,1,3])[0]).to.equal(1);
      expect(ex5([NaN,2,4,1,3])[1]).to.equal(2);
      expect(ex5([NaN,2,4,1,3])[2]).to.equal(3);
      expect(ex5([NaN,2,4,1,3])[3]).to.equal(4);
      expect(ex5([NaN,2,4,1,3])[4]).to.be.NaN;
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
  describe(`6 : Modify ex6 ...`, function(){
    it(`returns an array`, function(){
      expect(Array.isArray(ex6([1,2,3,4,5]))).to.be.true;
    });
    it(`rotates the array`, function(){
      expect(ex6([1,2,3,4,5],2)[0]).to.equal(3);
      expect(ex6([1,2,3,4,5],2)[1]).to.equal(4);
      expect(ex6([1,2,3,4,5],2)[2]).to.equal(5);
      expect(ex6([1,2,3,4,5],2)[3]).to.equal(1);
      expect(ex6([1,2,3,4,5],2)[4]).to.equal(2);
    });
    it(`did not alter the original array`, function(){
      expect(startingArray.length).to.equal(14);
      expect(startingArray).to.include.members([1,2,3,4,6,7,8,9,12,13,14]);
    });
  });
});