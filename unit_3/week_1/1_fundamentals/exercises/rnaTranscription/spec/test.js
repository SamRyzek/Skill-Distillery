describe('RNA Transciption Exercise', function() {
  describe('toRna()', function() {
    it('is a function', function() {
      expect(toRna).to.be.defined;
      expect(typeof toRna).to.equal('function');
    })
    it('transcribes cytosine to guanine', function() {
      expect(toRna('C')).to.equal('G');
    });

    it('transcribes guanine to cytosine', function() {
      expect(toRna('G')).to.equal('C');
    });

    it('transcribes adenine to uracil', function() {
      expect(toRna('A')).to.equal('U');
    });

    it('transcribes thymine to adenine', function() {
      expect(toRna('T')).to.equal('A');
    });

    it('transcribes all dna nucleotides to their rna complements', function() {
      expect(toRna('ACGTGGTCTTAA'))
          .to.equal('UGCACCAGAAUU');
    });
  });
})