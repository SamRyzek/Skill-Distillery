describe(`Game Logic - Objects ... Test Suite`, function() {
  describe(`1 : Create an object representing a square ...`, function() {
    it(`is defined`, function(){
      expect(square).to.be.defined;
    });
    it(`is an object`, function(){
      expect(typeof square).to.equal('object');
    });
    it(`has required properties`, function(){
      expect(square.xPos).to.be.defined;
      expect(square.yPos).to.be.defined;
      expect(square.width).to.be.defined;
      expect(square.height).to.be.defined;
      expect(square.color).to.be.defined;
    });
  });
  describe(`Movement Methods :`, function() {
    beforeEach(function() {
      square.xPos = 425;
      square.yPos = 275;
    });
    describe(`2 : Create a method on the square object named 'moveUp' ...`, function() {
      it(`moveUp is defined`, function(){
        expect(square.moveUp).to.be.defined;
      });
      it(`moveUp is a function`, function(){
        expect(typeof square.moveUp).to.equal('function');
      });
      it(`moveUp decreases the yPos property of square`, function(){
        var initPos = square.yPos;
        square.moveUp();
        expect(square.yPos).to.be.below(initPos);
      });
    });
    describe(`3 : Create a method on the square object named 'moveDown' ...`, function() {
      it(`moveDown is defined`, function(){
        expect(square.moveDown).to.be.defined;
      });
      it(`moveDown is a function`, function(){
        expect(typeof square.moveDown).to.equal('function');
      });
      it(`moveDown increases the yPos property of square`, function(){
        var initPos = square.yPos;
        square.moveDown();
        expect(square.yPos).to.be.above(initPos);
      });
    });
    describe(`4 : Create a method on the square object named 'moveLeft' ...`, function() {
      it(`moveLeft is defined`, function(){
        expect(square.moveLeft).to.be.defined;
      });
      it(`moveLeft is a function`, function(){
        expect(typeof square.moveLeft).to.equal('function');
      });
      it(`moveLeft decreases the xPos property of square`, function(){
        var initPos = square.xPos;
        square.moveLeft();
        expect(square.xPos).to.be.below(initPos);
      });
    });
    describe(`5 : Create a method on the square object named 'moveRight' ...`, function() {
      it(`moveRight is defined`, function(){
        expect(square.moveRight).to.be.defined;
      });
      it(`moveRight is a function`, function(){
        expect(typeof square.moveRight).to.equal('function');
      });
      it(`moveRight increases the xPos property of square`, function(){
        var initPos = square.xPos;
        square.moveRight();
        expect(square.xPos).to.be.above(initPos);
      });
    });
  });
  describe(`Collision Detection :`, function() {
    describe(`6 : Assign the 'walls' variable an object ...`, function() {
      it(`walls is defined`, function(){
        expect(walls).to.be.defined;
      });
      it(`walls is an object`, function(){
        expect(typeof walls).to.equal('object');
      });
      it(`has the required properties`, function() {
        expect(walls.xPos).to.be.defined;
        expect(walls.yPos).to.be.defined;
        expect(walls.width).to.be.defined;
        expect(walls.height).to.be.defined;
      });
    });
    describe(`7 : Create a method on the 'walls' object named 'checkCollision' ...`, function() {
      afterEach(function() {
        square.xPos = 425;
        square.yPos = 275;
      });
      it(`walls.checkCollision is defined`, function(){
        expect(walls.checkCollision).to.be.defined;
      });
      it(`walls.checkCollision is a function`, function(){
        expect(typeof walls.checkCollision).to.equal('function');
      });
      it(`it returns false if there is no collision with a wall when moved`, function(){
        expect(walls.checkCollision(square,'up')).to.be.false;
        expect(walls.checkCollision(square,'down')).to.be.false;
        expect(walls.checkCollision(square,'left')).to.be.false;
        expect(walls.checkCollision(square,'right')).to.be.false;
      });
      it(`it returns true when a moveUp would collide with a wall`, function(){
        square.yPos = 0;
        expect(walls.checkCollision(square, 'up')).to.be.true;
      });
      it(`it returns true when a moveDown would collide with a wall`, function(){
        square.yPos = 600;
        expect(walls.checkCollision(square, 'down')).to.be.true;
      });
      it(`it returns true when a moveLeft would collide with a wall`, function(){
        square.xPos = 0;
        expect(walls.checkCollision(square, 'left')).to.be.true;
      });
      it(`it returns true when a moveRight would collide with a wall`, function(){
        square.xPos = 900;
        expect(walls.checkCollision(square, 'right')).to.be.true;
      });
    });
    describe(`8 : Add your 'walls' object to the 'collidables' array ...`, function() {
      it(`collidables has a length of 1`, function() {
        expect(collidables.length).to.equal(1);
      });
      it(`the first element is an object`, function(){
        expect(typeof collidables[0]).to.equal('object');
      });
      it(`the object appears to be walls`, function(){
        expect(collidables[0].xPos).to.be.defined;
      });
    });
    describe(`9 : Create a method on the square object named 'checkForCollisions' ...`, function() {
      afterEach(function() {
        square.xPos = 425;
        square.yPos = 275;
      });
      it(`square.checkForCollisions is defined`, function(){
        expect(square.checkForCollisions).to.be.defined;
      });
      it(`square.checkForCollisions is a function`, function(){
        expect(typeof square.checkForCollisions).to.equal('function');
      });
      it(`it returns false if there is no collision with a wall when moved`, function(){
        expect(square.checkForCollisions('up')).to.be.false;
        expect(square.checkForCollisions('down')).to.be.false;
        expect(square.checkForCollisions('left')).to.be.false;
        expect(square.checkForCollisions('right')).to.be.false;
      });
      it(`it returns true when a moveUp would collide with a wall`, function(){
        square.yPos = 0;
        expect(square.checkForCollisions('up')).to.be.true;
      });
      it(`it returns true when a moveDown would collide with a wall`, function(){
        square.yPos = 600;
        expect(square.checkForCollisions('down')).to.be.true;
      });
      it(`it returns true when a moveLeft would collide with a wall`, function(){
        square.xPos = 0;
        expect(square.checkForCollisions('left')).to.be.true;
      });
      it(`it returns true when a moveRight would collide with a wall`, function(){
        square.xPos = 900;
        expect(square.checkForCollisions('right')).to.be.true;
      });
    });
    describe(`10 : Modify each of your 'move...' methods on square ...`, function() {
      afterEach(function() {
        square.xPos = 425;
        square.yPos = 275;
      });
    describe(`'moveUp' is disabled when ...`, function() {
      it(`square collides`, function(){
        square.yPos = 0;
        var initPos = square.yPos;
        square.moveUp();
        expect(square.yPos).to.equal(initPos);
      });
    });
    describe(`'moveDown' is disabled when ...`, function() {
      it(`square collides`, function(){
        square.yPos = 600;
        var initPos = square.yPos;
        square.moveDown();
        expect(square.yPos).to.equal(initPos);
      });
    });
    describe(`'moveLeft' is disabled when ...`, function() {
      it(`square collides`, function(){
        square.xPos = 0;
        var initPos = square.xPos;
        square.moveLeft();
        expect(square.xPos).to.equal(initPos);
      });
    });
    describe(`'moveRight' is disabled when ...`, function() {
      it(`square collides`, function(){
        square.xPos = 900;
        var initPos = square.xPos;
        square.moveRight();
        expect(square.xPos).to.equal(initPos);
      });
    });
    });
  });
});