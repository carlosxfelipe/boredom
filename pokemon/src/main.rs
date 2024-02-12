use reqwest;
use serde::Deserialize;

#[derive(Deserialize)]
struct Pokemon {
    name: String,
}

fn fetch_pokemon_name(pokemon_id: u32) -> Result<String, Box<dyn std::error::Error>> {
    let url = format!("https://pokeapi.co/api/v2/pokemon/{}", pokemon_id);
    let response = reqwest::blocking::get(url)?;

    if response.status().is_success() {
        let pokemon: Pokemon = response.json()?;
        Ok(pokemon.name)
    } else {
        Err("Não existe Pokémon com esse id".into())
    }
}

fn main() {
    let pokemon_id = 25;
    match fetch_pokemon_name(pokemon_id) {
        Ok(name) => println!("O nome do Pokémon é: {}", name),
        Err(error) => println!("Error: {}", error),
    }
}

// cargo run 

