import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class FriendshipsTest2 {
    private static Friendships f = new Friendships();


    @BeforeEach
    public void setup() {
        f.friendships = new HashMap<>();
    }
    @AfterEach
    public void teardown() {
        f.friendships = null;
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsNull() {

        assertThatThrownBy(() -> {
            f.makeFriends(null, "x");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsNull() {
        assertThatThrownBy(() -> {
            f.makeFriends("X", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsEmpty() {
        assertThatThrownBy(() -> {
            f.makeFriends("", "x");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsEmpty() {
        assertThatThrownBy(() -> {
            f.makeFriends("X", "");

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldMakeRecordInMapWhenThereIsNoGivenKeyInMap() {
        f.makeFriends("x", "y");
        assertThat(f.friendships.get("x").get(0)).isEqualTo("y");
        assertThat(f.friendships.get("x")).hasSize(1);
    }

    @Test
    public void ShouldAppendToListOfGivenKey() {
        f.makeFriends("x", "y");
        f.makeFriends("x", "z");
        assertThat(f.friendships.get("x").get(0)).isEqualTo("y");
        assertThat(f.friendships.get("x").get(1)).isEqualTo("z");
        assertThat(f.friendships.get("x")).hasSize(2);
    }

    @Test
    public void AfterAddingFriendToOnePersonSecondOneShouldHaveFriendshiptoo() {
        f.makeFriends("x", "y");
        assertThat(f.friendships.get("y").get(0)).isEqualTo("x");
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsNullInAreFriends() {
        assertThatThrownBy(() -> {
            f.areFriends(null, "x");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsNullInAreFriends() {
        assertThatThrownBy(() -> {
            f.areFriends("X", null);

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsEmptyInAreFriends() {
        assertThatThrownBy(() -> {
            f.areFriends("", "x");

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsEmptyInAreFriends() {
        assertThatThrownBy(() -> {
            f.areFriends("X", "");


        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenThereIsNoGivenKey() {
        assertThatThrownBy(() -> {
            f.areFriends("X", "Y");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldReturnTrueIfTwoPeopleAreFriends () {
        f.makeFriends("x", "y");
        assertThat(f.areFriends("x", "y")).isEqualTo(true);
    }

    @Test
    public void ShouldReturnFalseIfTwoPeopleAreNotFriends () {
        f.makeFriends("x", "y");
        assertThat(f.areFriends("x", "a")).isEqualTo(false);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonIsEmptyCallingGetFriendshipList() {
        assertThatThrownBy(() -> {
            f.getFriendsList("");

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonIsNullCallingGetFriendshipList() {
        assertThatThrownBy(() -> {
            f.getFriendsList(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonDoNotExistInMapCallingGetFriendshipList() {
        assertThatThrownBy(() -> {
            f.getFriendsList("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ShouldReturnFriendshipList() {
        f.makeFriends("x", "t");
        assertThat(f.getFriendsList("x")).hasSize(1);
        assertThat(f.getFriendsList("x").get(0)).isEqualTo("t");
    }





}