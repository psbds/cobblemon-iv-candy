$(document).ready(function () {
    // Add a visual cycling effect to the IV Extractor recipe to show different types
    let typeIndex = -1;
    const types = [
        "legendary", "mythical", "paradox", "ultrabeast",
        "fire", "grass", "water", "electric", "ice", "rock", "ground", "flying",
        "psychic", "bug", "poison", "fighting", "ghost", "dragon", "dark", "steel",
        "fairy", "normal"
    ];

    const $result = $('#extractor-recipe .crafting-result');
    const $shardSlot = $('#extractor-recipe .slot-3'); // Only the shard slot changes

    setInterval(() => {
        typeIndex = (typeIndex + 1) % types.length;
        const newType = types[typeIndex];

        // Update the shard image in slot 3 (top-right position)
        $shardSlot.find('img').attr('src', `../assets/images/items/shards/shard_${newType}.png`);
        
        // Update the extractor result image to match the shard type
        $result.find('img').first().attr('src', `../assets/images/items/extractor/iv_extractor_${newType}.png`);
    }, 1500); // Slightly slower cycle for better visibility
});