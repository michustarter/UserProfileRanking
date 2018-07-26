package com.capgemini.dataaccess.repository;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.exceptions.NullUsersException;

@Repository
public class UserDAO extends AdapterCrudDAO<UserEntity, Long> { // lepiej nie exte typlko imopleentacje int

	private final Map<Long, UserEntity> usersMap;

	public UserDAO(Map<Long, UserEntity> usersMap) {
		this.usersMap = usersMap; // tutaj powinienem dać chyba jednak: =new
									// Set<>(); ???
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		usersMap.put(userEntity.getId(), userEntity);

		return usersMap.get(userEntity.getId());
	}
	

	@Override
	public UserEntity findByID(Long userID) throws NullUsersException {
		if (!usersMap.keySet().contains(userID)) {
			throw new NullUsersException();
		}
		return usersMap.get(userID);
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		// w Servisie wywołam tę metodę i do tej metody po zmapowaniu z DTO na
		// Entity mam przekazać już obiekt do uaktualnieniea czyli tutaj z mapy
		// soibe wywolam konketne pola i zrobie na setterami
		if (!usersMap.containsKey(userEntity.getId())) {
			return null;
		}
		long idOfUpdate = userEntity.getId();
		UserEntity updatedUser = usersMap.get(idOfUpdate);
		// id nie sprawdzam bo tego nie zmienię nigdy

		if (userEntity.getFirstName() != null) {
			updatedUser.setFirstName(userEntity.getFirstName());
		}
		if (userEntity.getLastName() != null) {
			updatedUser.setLastName(userEntity.getLastName());
		}
		if (userEntity.getEmail() != null) {
			updatedUser.setEmail(userEntity.getEmail());
		}
		if (userEntity.getPassword() != null) {
			updatedUser.setPassword(userEntity.getPassword());
		}
		if (userEntity.getLifeMotto() != null) {
			updatedUser.setLifeMotto(userEntity.getLifeMotto());
		}
		if (userEntity.getGamesSet() != null) {
			updatedUser.setGamesSet(userEntity.getGamesSet());
		}
		if (userEntity.getAvailableFrom() != usersMap.get(idOfUpdate).getAvailableFrom()
				|| userEntity.getAvailableTo() != usersMap.get(idOfUpdate).getAvailableTo()
						&& userEntity.getNoAvailabilityComment() != "") {
			/*
			 * w if() nie wklejam skrótu updatedUser żeby nie mylić, bo
			 * sprawdzam aktualny stan mapy jeśli zauważono zmianę godzin
			 * dostępności - dodaję komentarz przekazany w obiekcie, jeśli jest
			 * różny od "" ten komentarz (choć można w sumie ten warunek != ""
			 * pominąć...
			 */
			updatedUser.setNoAvailabilityComment(userEntity.getNoAvailabilityComment());
		}
		if (userEntity.getAvailableFrom() != null
				&& userEntity.getAvailableFrom() != usersMap.get(idOfUpdate).getAvailableFrom()) {
			/*
			 * różny od NUlla i różny od początkowej godziny
			 */
			updatedUser.setAvailableFrom(userEntity.getAvailableFrom());
		}
		if (userEntity.getAvailableTo() != null
				&& userEntity.getAvailableTo() != usersMap.get(idOfUpdate).getAvailableTo()) {
			updatedUser.setAvailableTo(userEntity.getAvailableTo());

		}
		/*
		 * 
		 * } if (lastName != null) { userDTO.setLastName(lastName); } if (email
		 * != null) { userDTO.setEmail(email); } if (oldPassword != null &&
		 * newPassword != null && userDTO.getPassword().equals(oldPassword)) {
		 * userDTO.setPassword(newPassword); } if (lifeMotto != null) {
		 * userDTO.setLifeMotto(lifeMotto); }
		 * 
		 * saveModificationsInUserProfile(userDTO); return userDTO;
		 */

		return usersMap.get(idOfUpdate);
	}

	public void deleteAvailability(Long userID) {
		// ustawiam godz. pocz. i końcową na NULL + komentarz --> ok?
		usersMap.get(userID).setAvailableFrom(null);
		usersMap.get(userID).setAvailableTo(null);
		usersMap.get(userID).setNoAvailabilityComment("Nie mam czasu");

	}

	public Set<UserEntity> getUsers() {
		return usersMap.values().stream().collect(Collectors.toSet());
	}

	public int usersNumber() {
		return usersMap.size();
	}
}
