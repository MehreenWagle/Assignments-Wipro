import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NgModel } from '@angular/forms';

interface Movie {
  title: string;
  poster: string;
  genre: string;
  rating: number;
  description: string;
}

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatSelectModule, MatIconModule, MatFormFieldModule],
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent {
  genres: string[] = ['All', 'Action', 'Drama', 'Comedy', 'Sci-Fi'];

  movies: Movie[] = [
  {
    title: 'Inception',
    poster: 'https://m.media-amazon.com/images/I/71DwIcSgFcS.jpg',
    genre: 'Sci-Fi',
    rating: 5,
    description: 'A thief who steals corporate secrets through dream-sharing technology.'
  },
  {
    title: 'The Dark Knight',
    poster: 'https://i.pinimg.com/236x/b7/c8/1a/b7c81aaf567216bb249e994d0df03c45.jpg',
    genre: 'Action',
    rating: 5,
    description: 'Batman faces the Joker, a criminal mastermind spreading chaos in Gotham.'
  },
  {
    title: 'Interstellar',
    poster: 'https://m.media-amazon.com/images/I/91kFYg4fX3L._AC_SY679_.jpg',
    genre: 'Sci-Fi',
    rating: 4,
    description: 'A journey through space and time to save humanity.'
  },
  {
    title: 'Forrest Gump',
    poster: 'https://m.media-amazon.com/images/I/713xd8jGVuL._UF1000,1000_QL80_.jpg',
    genre: 'Drama',
    rating: 5,
    description: 'Life story of Forrest Gump who witnesses and influences historical events.'
  },

  {
    title: '3 Idiots',
    poster: 'https://i.etsystatic.com/40506978/r/il/a9b1b7/4660082536/il_570xN.4660082536_bwji.jpg',
    genre: 'Comedy',
    rating: 5,
    description: 'Three friends explore the pressures of engineering college in India.'
  },
  {
    title: 'Dangal',
    poster: 'https://upload.wikimedia.org/wikipedia/hi/9/99/Dangal_Poster.jpg',
    genre: 'Drama',
    rating: 5,
    description: 'A father trains his daughters to become world-class wrestlers.'
  },
  {
    title: 'Bahubali',
    poster: 'https://mir-s3-cdn-cf.behance.net/project_modules/1400_webp/9e081727685123.56369171b80b1.jpg',
    genre: 'Action',
    rating: 4,
    description: 'Epic tale of two brothers battling for the throne of Mahishmati.'
  },
  {
    title: 'Zindagi Na Milegi Dobara',
    poster: 'https://myhotposters.com/cdn/shop/products/mNS0731_large.jpg?v=1748539088',
    genre: 'Drama',
    rating: 4,
    description: 'Three friends rediscover life during a road trip across Spain.'
  }

];

  selectedGenre = 'All';

  get filteredMovies() {
    if (this.selectedGenre === 'All') return this.movies;
    return this.movies.filter(movie => movie.genre === this.selectedGenre);
  }

  get averageRating(): number {
    if (this.movies.length === 0) return 0;
    return this.movies.reduce((sum, m) => sum + m.rating, 0) / this.movies.length;
  }
}
