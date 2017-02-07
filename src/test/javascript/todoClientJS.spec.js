
it('To filter by owner Dawn, the URL should be http://localhost:4567/api/todos', function(){
   expect(urlCreator("owner", "dawn")).toBe("http://localhost:4567/api/todos?owner=dawn") ;
});

it('To filter by limit 10, the URL should be http://localhost:4567/api/todos?limit=10', function(){
   expect(urlCreator("limit", "10")).toBe("http://localhost:4567/api/todos?limit=10") ;
});

it('To filter by status false, the URL should be http://localhost:4567/api/todos?status=false', function(){
   expect(urlCreator("status", "false")).toBe("http://localhost:4567/api/todos?status=false") ;
});

it('To filter by todos containing the word officia, the URL should be http://localhost:4567/api/todos?contains=officia', function(){
   expect(urlCreator("contains", "officia")).toBe("http://localhost:4567/api/todos?contains=officia") ;
});

it('To filter by owner category homework, the URL should be http://localhost:4567/api/todos?category=homework', function(){
   expect(urlCreator("category", "homework")).toBe("http://localhost:4567/api/todos?category=homework");
});

