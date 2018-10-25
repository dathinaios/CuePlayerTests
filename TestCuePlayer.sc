
/*
  Run by evaluating:
    TestCuePlayer.new.run;
*/

TestCuePlayer : UnitTest {

  setUp {
    // this will be called before each test
  }

  tearDown {
    // this will be called after each test
  }

  test_cueplayer_put { var result;
    // Arrange: create an object
    var cuePlayer = CuePlayer.new;
    // Act: perform the action to be tested
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.add({result = 'cue 2'});
    cuePlayer.add({result = 'cue 3'});
    cuePlayer.put(2, {result = 'cue 2 replacement from .put'});
    // Assert: check that the action was performed correctly
    cuePlayer.next;
    this.assertEquals(result, 'cue 1');
    cuePlayer.next;
    this.assertEquals(result, 'cue 2 replacement from .put');
    cuePlayer.next;
    this.assertEquals(result, 'cue 3');
  }
  
  test_cueplayer_add { var result;
    // Arrange: create an object
    var cuePlayer = CuePlayer.new;
    // Act: perform the action to be tested
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.next;
    // Assert: check that the action was performed correctly
    this.assertEquals(result, 'cue 1');
  }

}
