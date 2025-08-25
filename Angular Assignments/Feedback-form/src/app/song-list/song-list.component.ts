import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';

interface Song {
  title: string;
  artist: string;
  album: string;
  duration: string;
  rating: number;
  language: 'english' | 'hindi';
}

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatSelectModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule
  ],
  styleUrls: ['./song-list.component.css']
})
export class SongListComponent {
  filterBy: string = 'artist'; // default filter
  filterValue: string = '';

  songs: Song[] = [
    { title: 'Perfect', artist: 'Ed Sheeran', album: 'Divide', duration: '4:23', rating: 5, language: 'english' },
    { title: 'Shape of You', artist: 'Ed Sheeran', album: 'Divide', duration: '4:10', rating: 4, language: 'english' },
    { title: 'Believer', artist: 'Imagine Dragons', album: 'Evolve', duration: '3:24', rating: 4, language: 'english' },
    { title: 'On My Way', artist: 'Alan Walker', album: 'Different World', duration: '3:14', rating: 4, language: 'english' },

    { title: 'Kesariya', artist: 'Arijit Singh', album: 'Brahmāstra', duration: '4:28', rating: 5, language: 'hindi' },
    { title: 'Apna Bana Le', artist: 'Arijit Singh', album: 'Bhediya', duration: '3:40', rating: 4, language: 'hindi' },
    { title: 'Raatan Lambiyan', artist: 'Jubin Nautiyal', album: 'Shershaah', duration: '3:50', rating: 5, language: 'hindi' },
    { title: 'Tum Hi Ho', artist: 'Arijit Singh', album: 'Aashiqui 2', duration: '4:22', rating: 5, language: 'hindi' }
  ];

  get filteredSongs() {
    if (!this.filterValue) return this.songs;
    return this.songs.filter(song =>
      String(song[this.filterBy as keyof Song]).toLowerCase().includes(this.filterValue.toLowerCase())
    );
  }
}
