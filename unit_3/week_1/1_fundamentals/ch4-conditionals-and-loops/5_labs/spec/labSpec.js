describe("Control Flow Test Suite", function() {
  describe(`1 : Write a for loop that takes the the value of base, and modifies 
    a variable (total) to 'base' to the power of 'pow'...`, function() {
      it(`Returns the the square of a number`, function() {
        expect(exponential(2,2)).to.equal(4);
        expect(exponential(3,2)).to.equal(9);
      });

      it(`Returns any exponential value`, function() {
        expect(exponential(2,8)).to.equal(256);
        expect(exponential(10,10)).to.equal(10000000000);
      });

      it(`Returns 1 if the value of pow is 0`, function() {
        expect(exponential(8,0)).to.equal(1);
        expect(exponential(100000,0)).to.equal(1);
      });

      it(`Returns NaN if one of the inputs is not a number`, function() {
        expect(exponential('banana', 2)).to.be.NaN;
      });
  });
  describe(`2 : Fibonacci function...`, function() {
    it(`Returns 3 as the 5th Fibonacci number`, function() {
      expect(fibonacci(5)).to.equal(3);
    });
    it(`Returns 13 as the 8th Fibonacci number`, function() {
      expect(fibonacci(8)).to.equal(13);
    });
    it(`Returns NaN if one of the inputs is not a number`, function() {
      expect(fibonacci('banana')).to.be.NaN;
    });
    it(`Returns 0 if n is negative, 0, or 1`, function() {
      expect(fibonacci(0)).to.equal(0);
      expect(fibonacci(1)).to.equal(0);
      expect(fibonacci(-1)).to.equal(0);
    });
    it(`Returns 1 if n is 1 or 2`, function() {
      expect(fibonacci(2)).to.equal(1);
      expect(fibonacci(3)).to.equal(1);
    });
  });
  describe(`3 : Reduce function...`, function() {
    it(`Adds all of the values in the array`, function() {
      expect(reduce('+', [1,2,3])).to.equal(6);
      expect(reduce('+', [-1,-2,-3])).to.equal(-6);
      expect(reduce('+', [8,10,-7])).to.equal(11);
    });
    it(`Subtracts all of the values in the array`, function() {
      expect(reduce('-', [1,2,3])).to.equal(-4);
      expect(reduce('-', [-1,-2,-3])).to.equal(4);
      expect(reduce('-', [8,10,-7])).to.equal(5);
    });
    it(`Multiplies all of the values in the array`, function() {
      expect(reduce('*', [1,2,3])).to.equal(6);
      expect(reduce('*', [-1,-2,-3])).to.equal(-6);
      expect(reduce('*', [8,10,-7])).to.equal(-560);
    });
    it(`Adds all of the values in the array`, function() {
      expect(reduce('/', [6,2,3])).to.equal(1);
      expect(reduce('/', [-10,-5,-2])).to.equal(-1);
      expect(reduce('/', [12,2,-3])).to.equal(-2);
    });
    it(`Returns "invalid operator" when provided something other than "+","-",
      "/","*"`, function() {
        expect(reduce('=', [1,2,3])).to.equal('invalid operator');
        expect(reduce('?', [1,2,3])).to.equal('invalid operator');
        expect(reduce('banana', [1,2,3])).to.equal('invalid operator');
        expect(reduce(9, [1,2,3])).to.equal('invalid operator');
    });
  });
  describe(`4 : Leap Years...`, function() {
    it(`Returns true if the year is a leap year`, function() {
      expect(isLeapYear(2016)).to.be.true;
    });
    it(`Returns false if the year is not a leap year`, function() {
      expect(isLeapYear(2017)).to.be.false;
    });
    it(`Accounts for remaining error`, function() {
      expect(isLeapYear(1700)).to.be.false;
      expect(isLeapYear(1800)).to.be.false;
      expect(isLeapYear(1900)).to.be.false;
      expect(isLeapYear(2100)).to.be.false;
      expect(isLeapYear(2200)).to.be.false;
      expect(isLeapYear(2300)).to.be.false;
      expect(isLeapYear(1600)).to.be.true;
      expect(isLeapYear(2000)).to.be.true;
      expect(isLeapYear(2400)).to.be.true;
    });
  })
});