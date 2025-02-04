FROM node:20-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json first (for caching purposes)
COPY package.json package-lock.json ./

# Install the app dependencies
RUN npm install

# Copy the rest of the application code into the container
COPY . .

# Build the React app
RUN npm run build

# Expose port 3000 for the React app
EXPOSE 3000

# Start the React application
CMD ["npm", "start"]