package project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
	
	Optional<Photo> findByTitle(String fileName);
}
