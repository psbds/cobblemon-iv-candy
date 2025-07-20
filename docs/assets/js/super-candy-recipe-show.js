$(document).ready(function () {
    // Add a visual highlight to the Super Candy recipe result when hovered for 3 seconds
    let typeIndex = -1;
    const types = [
        "legendary", "mythical", "paradox", "ultrabeast",
        "fire", "grass", "water", "electric", "ice", "rock", "ground", "flying",
        "psychic", "bug", "poison", "fighting", "ghost", "dragon", "dark", "steel",
        "fairy", "normal"
    ];

    let apricornIndex = 0;
    const apricorns = ["black", "yellow", "blue", "green", "red", "white"];
    const stats = ["stat_special_attack", "stat_attack", "stat_special_defense", "stat_defense", "stat_hp", "stat_speed"];

    const $result = $('#super-candy-recipe .crafting-result');
    const $shardSlots = $('#super-candy-recipe .slot-1, #super-candy-recipe .slot-2, #super-candy-recipe .slot-3, #super-candy-recipe .slot-4, #super-candy-recipe .slot-6, #super-candy-recipe .slot-7, #super-candy-recipe .slot-8, #super-candy-recipe .slot-9');
    const $apricornSlots = $('#super-candy-recipe .slot-5');

    setInterval(() => {
        typeIndex = (typeIndex + 1) % types.length;
        const newType = types[typeIndex];

        apricornIndex = Math.floor(Math.random() * apricorns.length);
        const newApricorn = apricorns[apricornIndex];
        const newStat = stats[apricornIndex];

        // Update the candy image to show different types
        $result.find('img').first().attr('src', `../assets/images/items/candies/candy_${newType}.png`);
        $result.find('img').eq(1).attr('src', `../assets/images/stats/${newStat}.png`);

        $shardSlots.find('img').attr('src', `../assets/images/items/shards/shard_${newType}.png`);
        $apricornSlots.find('img').attr('src', `../assets/images/items/apricorns/${newApricorn}_apricorn.png`);
    }, 1000);
});