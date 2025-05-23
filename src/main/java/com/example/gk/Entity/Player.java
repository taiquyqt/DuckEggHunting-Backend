package com.example.gk.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "white_duck", nullable = false)
    private int whiteDuck;

    @Column(name = "red_duck", nullable = false)
    private int redduck;

    @Column(name = "yellow_duck", nullable = false)
    private int yellowduck;

    @Column(name = "coins", nullable = false)
    private int coins;

    @Column(name = "eth", nullable = false)
    private double eth;
    
    @Column(name = "egg", nullable = false)
    private int egg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getWhiteDuck() {
		return whiteDuck;
	}

	public void setWhiteDuck(int whiteDuck) {
		this.whiteDuck = whiteDuck;
	}

	public int getRedduck() {
		return redduck;
	}

	public void setRedduck(int redduck) {
		this.redduck = redduck;
	}

	public int getYellowduck() {
		return yellowduck;
	}

	public void setYellowduck(int yellowduck) {
		this.yellowduck = yellowduck;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public double getEth() {
		return eth;
	}

	public void setEth(double eth) {
		this.eth = eth;
	}

	public int getEgg() {
		return egg;
	}

	public void setEgg(int egg) {
		this.egg = egg;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", token=" + token + ", whiteDuck=" + whiteDuck + ", redduck="
				+ redduck + ", yellowduck=" + yellowduck + ", coins=" + coins + ", eth=" + eth + ", egg=" + egg + "]";
	}
    
    
}
