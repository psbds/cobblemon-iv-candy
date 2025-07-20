$(document).ready(function () {
    // Add a visual highlight to the Super Candy recipe result when hovered for 3 seconds
    let typeIndex = -1;
    const types = [
        "legendary", "mythical", "paradox", "ultrabeast",
        "fire", "grass", "water", "electric", "ice", "rock", "ground", "flying",
        "psychic", "bug", "poison", "fighting", "ghost", "dragon", "dark", "steel",
        "fairy", "normal"
    ];

    const $result = $('#candy-recipe .crafting-result');
    const $shardSlots = $('#candy-recipe .slot-1, #candy-recipe .slot-2, #candy-recipe .slot-3, #candy-recipe .slot-4, #candy-recipe .slot-6, #candy-recipe .slot-7, #candy-recipe .slot-8, #candy-recipe .slot-9');

    setInterval(() => {
        typeIndex = (typeIndex + 1) % types.length;
        const newType = types[typeIndex];


        // Update the candy image to show different types
        $result.find('img').first().attr('src', `../assets/images/items/candies/candy_${newType}.png`);

        $shardSlots.find('img').attr('src', `../assets/images/items/shards/shard_${newType}.png`);
    }, 1000);
});