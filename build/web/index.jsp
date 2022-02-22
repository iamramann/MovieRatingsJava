<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Movie Ratings</title>
    </head>
    <body>
        <div class="container border border-light p-3 mt-3">
            <span class="h1 text-muted text-center w-100">Movies Rating</span>
            <form method="post" action="SaveMovieRating">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Movie name</label>
                    <input type="text" name="movie_name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <select class="form-select" aria-label="select release date" name="release_year">
                        <option selected>Release Year</option>
                        <option selected disabled>Please choose year</option>
                        <option value="2022">2022</option>
                        <option value="2021">2021</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="imdb" class="form-label">IMDB Rating</label>
                    <input type="text" name="imdb_rating" class="form-control" id="imdb">
                </div>
                <div class="mb-3">
                    <label for="tomato" class="form-label">Rotten Tomatos Rating</label>
                    <input type="text" name="tomato_rating" class="form-control" id="tomato" >
                </div>
                <!--                <div class="mb-3">
                                    <label for="formFile" class="form-label">Upload Movie poster</label>
                                    <input class="form-control" type="file" id="formFile">
                                </div>-->
                <button type="submit" class="btn btn-primary mt-3">Submit</button>
            </form>
            <div class="d-flex justify-content-between flex-column my-3 border border-light py-3">
                <span class="h3 lead "> Actions </span>
                <div class="my-3">
                    <a href="update_ratings.html" class="text-white  btn btn-warning">Update ratings</a>
                    <a href="delete_movie.html" class="btn btn-danger text-white">Delete a movie</a>
                    <a href="GetAllMovieList" class="btn btn-success text-white">View All movies</a>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
