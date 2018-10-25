TestCueplayer {
  
  test_cueplayer_add() {
	// Arrange: create an object
	var cuePlayer = Cueplayer.new;
	var result = cuePlayer.add({"cue 1"});
	// Act: perform the action to be tested
	var result = cuePlayer.next;
	// Assert: check that the action was performed correctly
	this.assertEquals(result, "cue 1");
}
}
