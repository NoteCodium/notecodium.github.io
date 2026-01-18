require 'find'

content_dir = File.join(Dir.pwd, 'CONTENT')

Find.find(content_dir) do |path|
  next unless path =~ /\.md$/

  content = File.read(path)
  
  # Check if file already has front matter
  unless content =~ /\A---\s*\n.*\n---\s*\n/m
    puts "Adding front matter to: #{path}"
    
    filename = File.basename(path, ".*")
    # Clean up filename for title (optional, just using filename for now)
    title = filename
    
    front_matter = <<~YAML
      ---
      layout: default
      title: "#{title}"
      ---
    YAML
    
    File.write(path, front_matter + content)
  end
end
