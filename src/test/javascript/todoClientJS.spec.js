
it('To filter by owner Dawn, the URL should be http://localhost:4567/api/todos', function(){
   expect(urlCreator("owner", "dawn")).toBe("http://localhost:4567/api/todos?owner=dawn") ;
});

