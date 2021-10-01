package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Str_collectionTest {
	
	Str_collection obj = new Str_collection(); //refractor

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	//-------------------------------------------------
	/*
	 * HELPER METHOD SECTION TO REFRACTOR
	 * */
	public void add(Str_collection the_obj, String element) {
		the_obj.add(element);
	}
	//-------------------------------------------------
	/*
	 * #1 - TC1
	 * */
	@Test
	void testAdd() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"burger");
		assertEquals(3,obj.len());
		
	}
	
	/*
	 * #1 - TC2
	 * */
	@Test
	void testAdd_duplication() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"burger");
		add(obj, "burrito");
		assertEquals(3,obj.len());
	}
	
	/*
	 * #2 - TC1
	 * */
	@Test
	void testCollection_notExist() {
		add(obj,"pizza");
		add(obj,"burrito");
		assertEquals("pizza burrito", obj.print());
	}
	/*
	 * #2 - TC2
	 * */
	@Test
	void testCollection_Exist() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"pizza");
		assertEquals("pizza burrito", obj.print()); //duplicated string will not be allowed to be inserted 
	}
	
	
	/*
	 * #3 - TC1 
	 * */
	@Test
	void testRandom() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"burger");
		boolean replacement = false;
		obj.getRandom(replacement);
		assertEquals(2,obj.len()); //The string should be removed from the collection
	}
	
	
	/*
	 * #3 - TC2
	 * */
	@Test
	void testRandom_notExist() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"burger");
		boolean replacement = false;
		String element = obj.getRandom(replacement);
		assertEquals(false,obj.contain(element)); //The element should no longer be in collection
		
	}
	
	
	/*
	 * #3 - TC3
	 * */
	@Test
	void testRandom_Exist() {
		add(obj,"pizza");
		add(obj,"burrito");
		add(obj,"burger");
		boolean replacement = true;
		String element = obj.getRandom(replacement);
		assertEquals(true,obj.contain(element)); //The element should still be in collection
	}
	
	/*
	 * This method will try to test several methods at a same time 
	 * 
	 * */
	@Test
	void testAll() {
		//"taco pizza hamburger burrito pasta soup salad"

		assertAll("test multiple functionalities together (using dependent test cases)", 
				() -> {
					add(obj,"taco");
					add(obj,"pizza");
					add(obj,"hamburger");
					add(obj,"burrito");
					add(obj,"pasta");
					add(obj,"soup");
					add(obj,"salad");
					assertEquals(7, obj.len());
					assertEquals("taco pizza hamburger burrito pasta soup salad", obj.print());
					add(obj,"soup");
					assertEquals(7, obj.len());
					String element = obj.getRandom(false);
					assertEquals(6, obj.len());
					assertEquals(false, obj.contain(element));
					
				}
				);
		
		
	}
	
	
	
	
	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
