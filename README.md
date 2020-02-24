
# ITunes Music Fetcher
This is a small application which fetch a list of tracks from apple music's API and allow user to play previews via streaming. It contains three Views:
1. Track List 
2. Collection Details
3. Last search queries List (not implemented yet)

All is made in a `dependency injection` pattern, which all relevant classes (`Room database`, `Repository dependencies` and `Use Cases`) are injected using an in-memory living object.

# Pending technical debts
1. Use a more flexible and scalable DI approach (like KodeIn, Koin or Dagger)
2. Some tests were not implemented
3. Last search Fragment
4. Empty states
5. And other ones 
