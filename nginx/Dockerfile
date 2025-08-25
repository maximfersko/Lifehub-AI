FROM nginx:alpine

# Copy custom nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Create directories for logs
RUN mkdir -p /var/log/nginx

# Create directory for SSL certificates (for production)
RUN mkdir -p /etc/nginx/certs

# Create directory for static files
RUN mkdir -p /var/www/static

# Expose ports
EXPOSE 80 443

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD curl -f http://localhost/health || exit 1

CMD ["nginx", "-g", "daemon off;"]
