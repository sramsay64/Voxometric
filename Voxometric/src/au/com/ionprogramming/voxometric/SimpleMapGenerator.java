package au.com.ionprogramming.voxometric;

import java.util.Random;

import au.com.ionprogramming.voxometric.blocks.Emerald;
import au.com.ionprogramming.voxometric.blocks.Grass;
import au.com.ionprogramming.voxometric.blocks.Water;

public class SimpleMapGenerator implements MapGenerator {

	private Random random;

	public SimpleMapGenerator() {
		this(new Random());
	}

	public SimpleMapGenerator(Random random) {
		this.random = random;
	}

	@Override
	public Chunk generate(Vector position) {
		int chunkSize = 64;
		Block[][][] blocks = new Block[chunkSize][chunkSize][chunkSize];
		for(int z = 0; z < chunkSize; z++){
			for(int y = 0; y < chunkSize - z; y++){
				for(int x = 0; x < chunkSize - z; x++){
					int rand = random.nextInt(10);
					if(rand >= 8){
						blocks[x][y][z] = new Water(x, y, z);
					}
					else if(rand <= 1){
						blocks[x][y][z] = new Emerald(x, y, z);
					}
					else if(rand < 8){
						blocks[x][y][z] = new Grass(x, y, z);
					}
				}
			}
		}
		return new Chunk(blocks);
	}
}