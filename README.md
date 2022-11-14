# Refined Data Model:
Actor
{
	Int: id,
	String: name,
	Int: movie_id
}

Category
{
	Int: id,
	String: name
}

Movie 
{
	Int: id,
	String: title,
	String: director,
	Int: category_id,
	Double: duration,
	String: rating,
	Int: yearReleased,
	String: imageName
}

Inventory
{
	Int: id,
	Int: movie_id,
	Double: price,
	Int: stockCount
}

* Created inventory schema to separate information that does not tie directly to the movie itself.
* Changed recording schema to movie.

# Query Results
3. List the number of videos for each video category. 
4. List the number of videos for each video category where the inventory is non-zero. 
5. For each actor, list the video categories that actor has appeared in. 
6. Which actors have appeared in movies in different video categories? 
7. Which actors have not appeared in a comedy? 
8. Which actors have appeared in both a comedy and an action adventure movie?

# Benefits/Drawbacks to MongoDB for this project:
As someone who is more familiar with SQL, I felt that it took much longer to write
the MongoDB queries, as there is a lot more setup. However, there is also less type-checking
compared to traditional SQL (when creating entries/variables, for example). I do think that
there is more setup when using MongoDB but it can also be versatile once the setup is done.

